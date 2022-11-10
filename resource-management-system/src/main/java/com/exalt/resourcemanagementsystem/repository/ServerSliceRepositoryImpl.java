package com.exalt.resourcemanagementsystem.repository;

import com.exalt.resourcemanagementsystem.dbconfiguration.Database;
import com.exalt.resourcemanagementsystem.models.server.dao.ServerSliceDao;

/**
 * The type Server slice repository.
 */
public class ServerSliceRepositoryImpl implements ServerSliceRepository{

  /**
   * The Aerospike.
   */
  Database aerospike = Database.getInstance();
  @Override
  public void createServerSlice(ServerSliceDao serverSliceDao){
    aerospike.mapper.save(serverSliceDao);
  }
  @Override
  public ServerSliceDao getServerSliceById(int id){
   return aerospike.mapper.read(ServerSliceDao.class,id);
  }


}
