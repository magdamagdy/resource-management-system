package com.exalt.resourcemanagementsystem.service;

import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.exception.ServerDownException;
import com.exalt.resourcemanagementsystem.models.server.dto.AllocationDto;
import com.exalt.resourcemanagementsystem.models.server.dto.ServerSliceDto;

/**
 * The interface Server service.
 */
public interface ServerService {

  /**
   * Server allocation server slice dto.
   * This method is internally invoked by allocateServer method
   * It handles all logic for allocation
   *
   * @param allocation     the allocation
   * @param targetServerId the target server id
   * @return the server slice dto
   * @throws ServerDownException the server down exception
   */
  ServerSliceDto serverAllocation(AllocationDto allocation, int targetServerId)throws ServerDownException;

  /**
   * Allocate server server slice dto.
   * This method handles the synchronization and threading
   * and in turns invokes the above serverAllocation method
   *
   * @param allocation the allocation
   * @return the server slice dto
   * @throws NullValueException   the null value exception
   * @throws ServerDownException  the server down exception
   * @throws InterruptedException the interrupted exception
   */
  ServerSliceDto allocateServer(AllocationDto allocation)
      throws NullValueException, ServerDownException, InterruptedException;
}
