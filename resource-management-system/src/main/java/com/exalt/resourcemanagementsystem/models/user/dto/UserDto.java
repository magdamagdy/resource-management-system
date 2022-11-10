package com.exalt.resourcemanagementsystem.models.user.dto;

import com.exalt.resourcemanagementsystem.models.server.dto.ServerSliceDto;
import java.util.List;

/**
 * The type User dto.
 */
public class UserDto {

  /**
   * The Id.
   */
  int id;
  /**
   * The Server slices.
   */
  List<ServerSliceDto> serverSlices;

  /**
   * Gets server slices.
   *
   * @return the server slices
   */
  public List<ServerSliceDto> getServerSlices() {
    return serverSlices;
  }

  /**
   * Sets server slices.
   *
   * @param serverSlices the server slices
   */
  public void setServerSlices(
      List<ServerSliceDto> serverSlices) {
    this.serverSlices = serverSlices;
  }

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
   * Instantiates a new User dto.
   */
  public UserDto() {
  }

  /**
   * Instantiates a new User dto.
   *
   * @param id           the id
   * @param serverSlices the server slices
   */
  public UserDto(int id, List<ServerSliceDto> serverSlices) {
    this.id = id;
    this.serverSlices = serverSlices;
  }
}
