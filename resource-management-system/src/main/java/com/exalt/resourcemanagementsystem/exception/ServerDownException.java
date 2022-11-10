package com.exalt.resourcemanagementsystem.exception;

/**
 * The type Server down exception.
 */
public class ServerDownException extends Exception{

  /**
   * Instantiates a new Server down exception.
   * This Exception is thrown when the target server status is not Active
   * @param errorMessage the error message
   */
  public ServerDownException (String errorMessage){
    super(errorMessage);
  }

}
