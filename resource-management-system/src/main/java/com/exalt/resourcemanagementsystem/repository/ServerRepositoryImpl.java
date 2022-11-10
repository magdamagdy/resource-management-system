package com.exalt.resourcemanagementsystem.repository;

import com.exalt.resourcemanagementsystem.dbconfiguration.Database;
import com.exalt.resourcemanagementsystem.models.server.dao.ServerDao;
import java.util.List;

/**
 * The type Server repository.
 */
public class ServerRepositoryImpl implements ServerRepository{

  private final String status = "status";
  private final String capacity = "capacity";

  /**
   * The Aerospike.
   */
  Database aerospike = Database.getInstance();

  @Override
  public List<ServerDao> getAllServers(){
    return aerospike.mapper.scan(ServerDao.class);
  }
  @Override

  public void createServer(ServerDao serverDao){
    aerospike.mapper.save(serverDao);
  }
  @Override

  public void updateServer(ServerDao serverDao){
    aerospike.mapper.update(serverDao, status, capacity);
  }
  @Override

  public ServerDao getServerById(int id){
    return aerospike.mapper.read(ServerDao.class, id);
  }

}
