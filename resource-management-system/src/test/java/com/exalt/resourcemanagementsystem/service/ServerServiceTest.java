package com.exalt.resourcemanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.exception.ServerDownException;
import com.exalt.resourcemanagementsystem.models.server.dao.ServerDao;
import com.exalt.resourcemanagementsystem.models.server.dto.AllocationDto;
import com.exalt.resourcemanagementsystem.models.server.dto.ServerSliceDto;
import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;
import org.junit.jupiter.api.Test;

/**
 * The type Server service test.
 */
class ServerServiceTest {

  /**
   * The User.
   */
  UserDao user = new UserDao(5, null);
  /**
   * The Allocation.
   */
  AllocationDto allocation = new AllocationDto(user.getId(), 50);
  /**
   * The Target server.
   */
  ServerDao targetServer = new ServerDao(4, "active", 100);
  /**
   * The Server service.
   */
  ServerService serverService = new ServerServiceImpl();

  /**
   * Server allocation not active status throws server down exception.
   */
  @Test
  void serverAllocation_NotActiveStatus_ThrowsServerDownException() {
    ServerDao targetServer = new ServerDao(4, "creating", 100);
    assertThrows(ServerDownException.class,
        () -> {
          serverService.serverAllocation(allocation, targetServer.getId());
        });
  }

  /**
   * Server allocation new allocation retrieved server slice consistent with allocation.
   *
   * @throws ServerDownException the server down exception
   */
  @Test
  void serverAllocation_NewAllocation_RetrievedServerSliceConsistentWithAllocation()
      throws ServerDownException {
    ServerSliceDto serverSlice = serverService.serverAllocation(allocation, targetServer.getId());
    assertTrue(serverSlice.getServer().getId() == targetServer.getId() &&
        serverSlice.getAllocatedCap() == allocation.getCapacity()
    );
  }

  /**
   * Allocate server null value throws null value exception.
   */
  @Test
  void allocateServer_NullValue_ThrowsNullValueException() {
    AllocationDto allocation = new AllocationDto(0, 50);
    assertThrows(NullValueException.class,
        () -> {
          serverService.allocateServer(allocation);
        });
  }

  /**
   * Allocate server new allocation retrieved server slice consistent with allocation.
   *
   * @throws InterruptedException the interrupted exception
   * @throws NullValueException   the null value exception
   * @throws ServerDownException  the server down exception
   */
  @Test
  void allocateServer_NewAllocation_RetrievedServerSliceConsistentWithAllocation() throws InterruptedException, NullValueException, ServerDownException {
    ServerSliceDto serverSlice = serverService.allocateServer(allocation);
    assertTrue(serverSlice.getAllocatedCap() == allocation.getCapacity() &&
        serverSlice.getServer().getId() == targetServer.getId());
  }
}