package com.exalt.resourcemanagementsystem.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.resourcemanagementsystem.models.server.dao.ServerDao;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


/**
 * The type Server repository test.
 */
class ServerRepositoryTest {

  /**
   * The Server repository.
   */
  ServerRepository serverRepository = new ServerRepositoryImpl();

  /**
   * Gets all servers existing no of records list of records not null.
   */
  @Test
  void getAllServers_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<ServerDao> allRecords = new ArrayList<>(serverRepository.getAllServers());
    assertTrue(allRecords.size() > 0);
  }

  /**
   * Create and get server by id new server new saved record is consistent with retrieved record.
   */
  @Test
  void createAndGetServerById_NewServer_NewSavedRecordIsConsistentWithRetrievedRecord() {
    ServerDao newRecord = new ServerDao(1, "active", 100);
    serverRepository.createServer(newRecord);
    ServerDao retrievedRecord = serverRepository.getServerById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getStatus().equals(retrievedRecord.getStatus()) &&
        newRecord.getCapacity() == retrievedRecord.getCapacity());
  }

  /**
   * Update server existing server retrieved record is updated.
   */
  @Test
  void updateServer_ExistingServer_RetrievedRecordIsUpdated() {
    serverRepository.createServer(new ServerDao(2, "active", 100));
    ServerDao existingServer = serverRepository.getServerById(2);
    ServerDao updates = new ServerDao(2, "creating", 60);
    serverRepository.updateServer(updates);
    ServerDao updatedServer = serverRepository.getServerById(2);
    assertTrue(existingServer.getId() == updatedServer.getId() &&
        !existingServer.getStatus().equals(updatedServer.getStatus()) &&
        existingServer.getCapacity() != updatedServer.getCapacity());
  }

}