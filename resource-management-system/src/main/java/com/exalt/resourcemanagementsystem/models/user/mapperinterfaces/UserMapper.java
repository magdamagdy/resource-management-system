package com.exalt.resourcemanagementsystem.models.user.mapperinterfaces;

import com.exalt.resourcemanagementsystem.models.user.dao.UserDao;
import com.exalt.resourcemanagementsystem.models.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface User mapper.
 */
@Mapper
public interface UserMapper {

  /**
   * The constant INSTANCE.
   */
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  /**
   * User dto to user dao user dao.
   *
   * @param user the user
   * @return the user dao
   */
  UserDao userDtoToUserDao(UserDto user);

  /**
   * User dao to user dto user dto.
   *
   * @param user the user
   * @return the user dto
   */
  UserDto userDaoToUserDto(UserDao user);

}
