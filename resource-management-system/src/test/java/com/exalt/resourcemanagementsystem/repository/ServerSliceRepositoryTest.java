package com.exalt.resourcemanagementsystem.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.resourcemanagementsystem.models.server.dao.ServerDao;
import com.exalt.resourcemanagementsystem.models.server.dao.ServerSliceDao;
import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;
import org.junit.jupiter.api.Test;

/**
 * The type Server slice repository test.
 */
class ServerSliceRepositoryTest {

  /**
   * The Server.
   */
  ServerDao server = new ServerDao(1,"active",80);
  /**
   * The User.
   */
  UserDao user =new UserDao(3,null);
  /**
   * The Server slice repository.
   */
  ServerSliceRepository serverSliceRepository = new ServerSliceRepositoryImpl();

  /**
   * Create and get server slice by id new server slice new saved record is consistent with
   * retrieved record.
   */
  @Test
  void createAndGetServerSliceById_NewServerSlice_NewSavedRecordIsConsistentWithRetrievedRecord() {
    ServerSliceDao newRecord= new ServerSliceDao(1,server,user,20);
    serverSliceRepository.createServerSlice(newRecord);
    ServerSliceDao retrievedRecord = serverSliceRepository.getServerSliceById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getServer().getId() == retrievedRecord.getServer().getId() &&
        newRecord.getAllocatedCap() == retrievedRecord.getAllocatedCap());
  }

}