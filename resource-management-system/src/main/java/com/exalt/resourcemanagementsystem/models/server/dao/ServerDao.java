package com.exalt.resourcemanagementsystem.models.server.dao;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

/**
 * The type Server dao.
 */
@AerospikeRecord(namespace = "test", set = "server")
public class ServerDao {

  @AerospikeKey
  private int id;
  private String status;
  private int capacity; //real remaining capacity

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
   * Gets status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Gets capacity.
   *
   * @return the capacity
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Sets capacity.
   *
   * @param capacity the capacity
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Instantiates a new Server dao.
   */
  public ServerDao() {
  }

  /**
   * Instantiates a new Server dao.
   *
   * @param id       the id
   * @param status   the status
   * @param capacity the capacity
   */
  public ServerDao(int id, String status, int capacity) {
    this.id = id;
    this.status = status;
    this.capacity = capacity;
  }
}
