package com.exalt.resourcemanagementsystem.exception;

/**
 * The type Null value exception.
 */
public class NullValueException extends Exception{

  /**
   * Instantiates a new Null value exception.
   * This exception is thrown when the client side posted null object or null value id or id = 0
   * @param errorMessage the error message
   */
  public NullValueException(String errorMessage){
    super(errorMessage);
  }
}
