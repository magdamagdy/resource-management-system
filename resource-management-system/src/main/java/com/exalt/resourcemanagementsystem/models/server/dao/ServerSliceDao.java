package com.exalt.resourcemanagementsystem.models.server.dao;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;

/**
 * The type Server slice dao.
 */
@AerospikeRecord(namespace = "test", set = "serverSlice")
public class ServerSliceDao {

  @AerospikeKey
  private int id;

  @AerospikeReference
  private ServerDao server;

  @AerospikeReference
  private UserDao user;

  private int allocatedCap;

  /**
   * Gets id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets server.
   *
   * @return the server
   */
  public ServerDao getServer() {
    return server;
  }

  /**
   * Sets server.
   *
   * @param server the server
   */
  public void setServer(ServerDao server) {
    this.server = server;
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public UserDao getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param user the user
   */
  public void setUser(UserDao user) {
    this.user = user;
  }

  /**
   * Gets allocated cap.
   *
   * @return the allocated cap
   */
  public int getAllocatedCap() {
    return allocatedCap;
  }

  /**
   * Sets allocated cap.
   *
   * @param allocatedCap the allocated cap
   */
  public void setAllocatedCap(int allocatedCap) {
    this.allocatedCap = allocatedCap;
  }

  /**
   * Instantiates a new Server slice dao.
   */
  public ServerSliceDao() {
  }

  /**
   * Instantiates a new Server slice dao.
   *
   * @param id           the id
   * @param server       the server
   * @param user         the user
   * @param allocatedCap the allocated cap
   */
  public ServerSliceDao(int id, ServerDao server, UserDao user, int allocatedCap) {
    this.id = id;
    this.server = server;
    this.user = user;
    this.allocatedCap = allocatedCap;
  }
}
