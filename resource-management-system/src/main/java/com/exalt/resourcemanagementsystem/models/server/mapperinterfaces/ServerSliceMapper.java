package com.exalt.resourcemanagementsystem.models.server.mapperinterfaces;

import com.exalt.resourcemanagementsystem.models.server.dao.ServerSliceDao;
import com.exalt.resourcemanagementsystem.models.server.dto.ServerSliceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface Server slice mapper.
 */
@Mapper
public interface ServerSliceMapper {

  /**
   * The constant INSTANCE.
   */
  ServerSliceMapper INSTANCE = Mappers.getMapper( ServerSliceMapper.class );

  /**
   * Server slice dto to server slice dao server slice dao.
   *
   * @param serverSlice the server slice
   * @return the server slice dao
   */
  ServerSliceDao serverSliceDtoToServerSliceDao(ServerSliceDto serverSlice);

  /**
   * Server slice dao to server slice dto server slice dto.
   *
   * @param serverSlice the server slice
   * @return the server slice dto
   */
  ServerSliceDto serverSliceDaoToServerSliceDto(ServerSliceDao serverSlice);

}
