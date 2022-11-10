package com.exalt.resourcemanagementsystem.models.server.dto;

/**
 * The type Server dto.
 */
public class ServerDto {
  private int id;
  private String status;
  private int capacity;

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
   * Instantiates a new Server dto.
   */
  public ServerDto() {
  }

  /**
   * Instantiates a new Server dto.
   *
   * @param id       the id
   * @param status   the status
   * @param capacity the capacity
   */
  public ServerDto(int id, String status, int capacity) {
    this.id = id;
    this.status = status;
    this.capacity = capacity;
  }
}
