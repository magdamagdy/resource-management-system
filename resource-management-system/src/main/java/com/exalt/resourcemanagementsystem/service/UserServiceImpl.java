package com.exalt.resourcemanagementsystem.service;

import com.exalt.resourcemanagementsystem.exception.NotFoundException;
import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;
import com.exalt.resourcemanagementsystem.models.user.dto.UserDto;
import com.exalt.resourcemanagementsystem.models.user.mapperinterfaces.UserMapper;
import com.exalt.resourcemanagementsystem.repository.UserRepositoryImpl;

/**
 * The type User service.
 */
public class UserServiceImpl implements UserService{

  private final String nullValueMsg = "Null object or Null id";
  private final String notFoundMsg = "User not found";
  /**
   * The User repository.
   */
  UserRepositoryImpl userRepository = new UserRepositoryImpl();
  @Override
  public UserDto createUser(UserDto user) throws NullValueException {
    if (user.getId() == 0) {
      throw new NullValueException(nullValueMsg);
    }
    UserDao userDao = UserMapper.INSTANCE.userDtoToUserDao(user);
    userRepository.saveUser(userDao);

    return UserMapper.INSTANCE.userDaoToUserDto(userRepository.getUserById(user.getId()));
  }

  @Override
  public UserDto getUserById(int id) throws NotFoundException {
    UserDao userDao = userRepository.getUserById(id);
    if(userDao == null){
      throw new NotFoundException(notFoundMsg);
    }
    return UserMapper.INSTANCE.userDaoToUserDto(userDao);
  }
}
