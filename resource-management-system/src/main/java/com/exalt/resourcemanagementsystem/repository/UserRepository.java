package com.exalt.resourcemanagementsystem.repository;

import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;

/**
 * The interface User repository.
 */
public interface UserRepository {

  /**
   * Save user.
   *
   * @param user the user
   */
  void saveUser(UserDao user);

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   */
  UserDao getUserById(int id);
}
