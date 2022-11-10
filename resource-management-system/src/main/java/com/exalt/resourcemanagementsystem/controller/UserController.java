package com.exalt.resourcemanagementsystem.controller;

import com.exalt.resourcemanagementsystem.exception.NotFoundException;
import com.exalt.resourcemanagementsystem.exception.NullValueException;
import com.exalt.resourcemanagementsystem.models.user.dto.UserDto;
import com.exalt.resourcemanagementsystem.service.UserService;
import com.exalt.resourcemanagementsystem.service.UserServiceImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type User controller.
 */
@Path("/user")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final String nullWarningMsg = "Posted null value object or null id";
  private final String notFoundWarningMsg = "User object not found when searching by id";
  private final String internalServerErrorMsg = "Internal server error!!";

  /**
   * The User service.
   */
  UserService userService = new UserServiceImpl();

  /**
   * Create user response.
   *
   * @param user the user
   * @return the response
   */
  @POST
  @Path("/create")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser (UserDto user){
    try {
      return Response.ok(userService.createUser(user)).build();
    }
    catch (NullValueException e){
      LOGGER.warn(nullWarningMsg);
      return Response.status(400, e.getMessage()).build();
    }
    catch (Exception e) {
      LOGGER.info(internalServerErrorMsg);
      return Response.serverError().build();
    }
  }

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserById (@PathParam("id") int id){
    try {
      return Response.ok(userService.getUserById(id)).build();
    }
    catch (NotFoundException e){
      LOGGER.warn(notFoundWarningMsg);
      return Response.status(404, e.getMessage()).build();
    }
    catch (Exception e) {
      LOGGER.info(internalServerErrorMsg);
      return Response.serverError().build();
    }
  }
}
