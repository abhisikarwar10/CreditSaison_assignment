package com.example.assignment_abhishek.Exception;

public class DataNotFoundException extends Exception{
    public DataNotFoundException(){super("No data found for the given entries, Bad Request");}
}
