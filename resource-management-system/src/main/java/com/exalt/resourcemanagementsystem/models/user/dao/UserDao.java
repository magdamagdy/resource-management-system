package com.exalt.resourcemanagementsystem.models.user.dao;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.exalt.resourcemanagementsystem.models.server.dao.ServerSliceDao;
import java.util.List;

/**
 * The type User dao.
 */
@AerospikeRecord(namespace = "test", set = "user")
public class UserDao {

  @AerospikeKey
  private int id;
  @AerospikeReference
  private List<ServerSliceDao> serverSlices;

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
   * Gets server slices.
   *
   * @return the server slices
   */
  public List<ServerSliceDao> getServerSlices() {
    return serverSlices;
  }

  /**
   * Sets server slices.
   *
   * @param serverSlices the server slices
   */
  public void setServerSlices(
      List<ServerSliceDao> serverSlices) {
    this.serverSlices = serverSlices;
  }

  /**
   * Instantiates a new User dao.
   */
  public UserDao() {
  }

  /**
   * Instantiates a new User dao.
   *
   * @param id           the id
   * @param serverSlices the server slices
   */
  public UserDao(int id, List<ServerSliceDao> serverSlices) {
    this.id = id;
    this.serverSlices = serverSlices;
  }
}
