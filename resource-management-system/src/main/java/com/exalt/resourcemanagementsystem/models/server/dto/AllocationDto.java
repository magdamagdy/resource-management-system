package com.exalt.resourcemanagementsystem.models.server.dto;

/**
 * The type Allocation dto.
 */
public class AllocationDto {
  private int userId;
  private int capacity;

  /**
   * Gets user id.
   *
   * @return the user id
   */
  public int getUserId() {
    return userId;
  }

  /**
   * Sets user id.
   *
   * @param userId the user id
   */
  public void setUserId(int userId) {
    this.userId = userId;
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
   * Instantiates a new Allocation dto.
   */
  public AllocationDto() {
  }

  /**
   * Instantiates a new Allocation dto.
   *
   * @param userId   the user id
   * @param capacity the capacity
   */
  public AllocationDto(int userId, int capacity) {
    this.userId = userId;
    this.capacity = capacity;
  }
}
