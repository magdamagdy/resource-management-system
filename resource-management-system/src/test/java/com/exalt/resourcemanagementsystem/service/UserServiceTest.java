package com.exalt.resourcemanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.resourcemanagementsystem.exception.NotFoundException;
import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.models.user.dto.UserDto;
import org.junit.jupiter.api.Test;

/**
 * The type User service test.
 */
class UserServiceTest {

  /**
   * The User service.
   */
  UserService userService = new UserServiceImpl();

  /**
   * Create user null value throws null value exception.
   */
  @Test
  void createUser_NullValue_ThrowsNullValueException() {
    UserDto user = new UserDto(0, null);
    assertThrows(NullValueException.class,
        () -> {
          userService.createUser(user);
        });
  }

  /**
   * Create user new user retrieved user consistent with newly added one.
   *
   * @throws NullValueException the null value exception
   */
  @Test
  void createUser_NewUser_RetrievedUserConsistentWithNewlyAddedOne() throws NullValueException {
    UserDto newUser = new UserDto(4, null);
    UserDto retrievedUser = userService.createUser(newUser);
    assertTrue(newUser.getId() == retrievedUser.getId() &&
        newUser.getServerSlices() == retrievedUser.getServerSlices());
  }

  /**
   * Gets user by id not existing user throws not found exception.
   */
  @Test
  void getUserById_NotExistingUser_ThrowsNotFoundException() {
    assertThrows(NotFoundException.class,
        () -> {
          userService.getUserById(50);
        });
  }
}