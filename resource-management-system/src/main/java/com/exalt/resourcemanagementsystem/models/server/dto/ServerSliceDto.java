package com.exalt.resourcemanagementsystem.models.server.dto;


/**
 * The type Server slice dto.
 */
public class ServerSliceDto {

  private int id;
  private ServerDto server;
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
  public ServerDto getServer() {
    return server;
  }

  /**
   * Sets server.
   *
   * @param server the server
   */
  public void setServer(ServerDto server) {
    this.server = server;
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
   * Instantiates a new Server slice dto.
   */
  public ServerSliceDto() {
  }

  /**
   * Instantiates a new Server slice dto.
   *
   * @param id           the id
   * @param server       the server
   * @param allocatedCap the allocated cap
   */
  public ServerSliceDto(int id, ServerDto server, int allocatedCap) {
    this.id = id;
    this.server = server;
    this.allocatedCap = allocatedCap;
  }
}
