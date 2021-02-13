package com.example.assignment_abhishek.Exception;

public class InvalidPageOrLimitException extends Exception {
    public InvalidPageOrLimitException(){super("Page Number or Limit can not be less than 1");}
}
