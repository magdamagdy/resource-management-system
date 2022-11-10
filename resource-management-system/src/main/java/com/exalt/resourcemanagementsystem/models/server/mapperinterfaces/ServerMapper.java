package com.exalt.resourcemanagementsystem.models.server.mapperinterfaces;

import com.exalt.resourcemanagementsystem.models.server.dao.ServerDao;
import com.exalt.resourcemanagementsystem.models.server.dto.ServerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface Server mapper.
 */
@Mapper
public interface ServerMapper {

  /**
   * The constant INSTANCE.
   */
  ServerMapper INSTANCE = Mappers.getMapper( ServerMapper.class );

  /**
   * Server dto to server dao server dao.
   *
   * @param server the server
   * @return the server dao
   */
  ServerDao serverDtoToServerDao(ServerDto server);

  /**
   * Server dao to server dto server dto.
   *
   * @param server the server
   * @return the server dto
   */
  ServerDto serverDaoToServerDto(ServerDao server);

}
