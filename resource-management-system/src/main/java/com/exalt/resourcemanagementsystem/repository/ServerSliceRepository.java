package com.exalt.resourcemanagementsystem.repository;

import com.exalt.resourcemanagementsystem.models.server.dao.ServerSliceDao;

/**
 * The interface Server slice repository.
 */
public interface ServerSliceRepository {

  /**
   * Create server slice.
   *
   * @param serverSliceDao the server slice dao
   */
  void createServerSlice(ServerSliceDao serverSliceDao);

  /**
   * Gets server slice by id.
   *
   * @param id the id
   * @return the server slice by id
   */
  ServerSliceDao getServerSliceById(int id);
}
