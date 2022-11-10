package com.exalt.resourcemanagementsystem.repository;

import com.exalt.resourcemanagementsystem.models.server.dao.ServerDao;
import java.util.List;

/**
 * The interface Server repository.
 */
public interface ServerRepository {

  /**
   * Gets all servers.
   *
   * @return the all servers
   */
  List<ServerDao> getAllServers();

  /**
   * Create server.
   *
   * @param serverDao the server dao
   */
  void createServer(ServerDao serverDao);

  /**
   * Update server.
   *
   * @param serverDao the server dao
   */
  void updateServer(ServerDao serverDao);

  /**
   * Gets server by id.
   *
   * @param id the id
   * @return the server by id
   */
  ServerDao getServerById(int id);
}
