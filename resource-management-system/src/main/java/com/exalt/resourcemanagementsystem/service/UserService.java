package com.exalt.resourcemanagementsystem.service;

import com.exalt.resourcemanagementsystem.exception.NotFoundException;
import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.models.user.dto.UserDto;

/**
 * The interface User service.
 */
public interface UserService {

  /**
   * Create user user dto.
   *
   * @param user the user
   * @return the user dto
   * @throws NullValueException the null value exception
   */
  UserDto createUser(UserDto user) throws NullValueException;

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   * @throws NotFoundException the not found exception
   */
  UserDto getUserById(int id) throws NotFoundException;
}
