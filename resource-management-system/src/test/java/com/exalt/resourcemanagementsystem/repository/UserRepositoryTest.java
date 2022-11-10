package com.exalt.resourcemanagementsystem.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;
import org.junit.jupiter.api.Test;

/**
 * The type User repository test.
 */
class UserRepositoryTest {

  /**
   * The User repository.
   */
  UserRepository userRepository = new UserRepositoryImpl();

  /**
   * Save and get user by id new user new saved record is consistent with retrieved record.
   */
  @Test
  void saveAndGetUserById_NewUser_NewSavedRecordIsConsistentWithRetrievedRecord() {
    UserDao newRecord = new UserDao(4, null);
    userRepository.saveUser(newRecord);
    UserDao retrievedRecord = userRepository.getUserById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getServerSlices() == retrievedRecord.getServerSlices());
  }

}