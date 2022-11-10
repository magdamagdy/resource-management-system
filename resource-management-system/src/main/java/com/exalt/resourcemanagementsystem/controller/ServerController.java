package com.exalt.resourcemanagementsystem.controller;

import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.exception.ServerDownException;
import com.exalt.resourcemanagementsystem.models.server.dto.AllocationDto;
import com.exalt.resourcemanagementsystem.service.ServerService;
import com.exalt.resourcemanagementsystem.service.ServerServiceImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Server controller.
 */
@Path("/server")
public class ServerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServerController.class);

  private final String nullWarningMsg = "Posted null value object or null id";
  private final String serverDownMsg = "Server status is not Active or failed to allocate the a server";

  private final String internalServerErrorMsg = "Internal server error";
  /**
   * The Server service.
   */
  ServerService serverService = new ServerServiceImpl();

  /**
   * Allocate server response.
   *
   * @param allocation the allocation
   * @return the response
   */
  @POST
  @Path("/allocate")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response allocateServer(AllocationDto allocation) {
    try {
      return Response.ok(serverService.allocateServer(allocation)).build();
    }
    catch (NullValueException e) {
      LOGGER.warn(nullWarningMsg);
      return Response.status(400, e.getMessage()).build();
    }
    catch (ServerDownException e) {
      LOGGER.warn(serverDownMsg);
      return Response.status(501, e.getMessage()).build();
    }
    catch (Exception e) {
      LOGGER.info(internalServerErrorMsg);
      return Response.serverError().build();
    }
  }
}
