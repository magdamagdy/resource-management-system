package com.exalt.resourcemanagementsystem.exception;

/**
 * The type Not found exception.
 */
public class NotFoundException extends Exception{

  /**
   * Instantiates a new Not found exception.
   * This exception is thrown on searching for object in database, and it is not found
   * @param errorMessage the error message
   */
  public NotFoundException (String errorMessage){
    super(errorMessage);
  }

}
