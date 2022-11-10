package com.exalt.resourcemanagementsystem.service;

import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.exception.ServerDownException;
import com.exalt.resourcemanagementsystem.models.server.dao.ServerDao;
import com.exalt.resourcemanagementsystem.models.server.dao.ServerSliceDao;
import com.exalt.resourcemanagementsystem.models.server.dto.AllocationDto;
import com.exalt.resourcemanagementsystem.models.server.dto.ServerSliceDto;
import com.exalt.resourcemanagementsystem.models.server.mapperinterfaces.ServerSliceMapper;
import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;
import com.exalt.resourcemanagementsystem.repository.ServerRepository;
import com.exalt.resourcemanagementsystem.repository.ServerRepositoryImpl;
import com.exalt.resourcemanagementsystem.repository.ServerSliceRepository;
import com.exalt.resourcemanagementsystem.repository.ServerSliceRepositoryImpl;
import com.exalt.resourcemanagementsystem.repository.UserRepository;
import com.exalt.resourcemanagementsystem.repository.UserRepositoryImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * The type Server service.
 */
public class ServerServiceImpl implements ServerService {

  private final String nullValueMsg = "Null object or Null id";
  private final String serverDownMsg = "Server is down";


  /**
   * The User repository.
   */
  UserRepository userRepository = new UserRepositoryImpl();
  /**
   * The Server repository.
   */
  ServerRepository serverRepository = new ServerRepositoryImpl();
  /**
   * The Server slice repository.
   */
  ServerSliceRepository serverSliceRepository = new ServerSliceRepositoryImpl();
  /**
   * The Rand.
   */
  Random rand = new Random();

  @Override
  public ServerSliceDto serverAllocation(AllocationDto allocation, int targetServerId)
      throws ServerDownException {
    ServerDao targetServer = serverRepository.getServerById(targetServerId);
    //allocate the required capacity by updating the created server
    targetServer.setCapacity(targetServer.getCapacity() - allocation.getCapacity());
    targetServer.setStatus("active");
    serverRepository.updateServer(targetServer);

    //save the server slice
    UserDao user = userRepository.getUserById(allocation.getUserId());
    ServerSliceDao serverSlice = new ServerSliceDao(rand.nextInt(1000), targetServer, user,
        allocation.getCapacity());
    serverSliceRepository.createServerSlice(serverSlice);

    //save the slice to the user list of slices
    if (user.getServerSlices() == null) {
      List<ServerSliceDao> serverSlicesList = Arrays.asList(serverSlice);
      user.setServerSlices(serverSlicesList);
    } else {
      List<ServerSliceDao> serverSlicesList = new ArrayList<>(user.getServerSlices());
      serverSlicesList.add(serverSlice);
      user.setServerSlices(serverSlicesList);
    }
    //save the user updates
    userRepository.saveUser(user);

    //if the server status is active then return the slice details
    if (serverRepository.getServerById(targetServerId).getStatus().equals("active")) {
      return ServerSliceMapper.INSTANCE.serverSliceDaoToServerSliceDto(
          serverSliceRepository.getServerSliceById(serverSlice.getId()));
    }
    throw new ServerDownException(serverDownMsg);

  }

  @Override
  public ServerSliceDto allocateServer(AllocationDto allocation)
      throws NullValueException, ServerDownException, InterruptedException {
    if (allocation.getUserId() == 0 || allocation.getCapacity() == 0) {
      throw new NullValueException(nullValueMsg);
    }
    /**
     * critical section
     */
    synchronized (this) {
      List<ServerDao> allServers = serverRepository.getAllServers();
      /**
       * Searching for server with sufficient capacity
       */
      int targetServerId = 0;
      if (allServers.size() != 0) {
        for (ServerDao existingServer : allServers) {
          if ((existingServer.getCapacity() >= allocation.getCapacity())
              && (existingServer.getStatus().equals("active"))) {
            targetServerId = existingServer.getId();
            break;
          }
        }
      }
      if (targetServerId != 0) {
        return serverAllocation(allocation, targetServerId);
      }
      /**
       * If there is no servers in the database or
       * There is no server in the database has the sufficient capacity
       */
      else {

        /**
         * create new server of capacity 100
         * Creating server takes time 1 min = 60000 millisecond with thread.sleep
         */
        ServerDao newServer = new ServerDao(rand.nextInt(1000000), "creating", 100);
        serverRepository.createServer(newServer);
        Thread.sleep(60000);
        return serverAllocation(allocation, newServer.getId());
      }
    }
  }
}
