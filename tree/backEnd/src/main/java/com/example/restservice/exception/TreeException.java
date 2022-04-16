//    Written By: Alireza Boroumandyar
// First Written: 2022-03-18
//   Last Update: 2022-03-18

// a custom exception to manage error

package com.example.restservice.exception;

public class TreeException extends Exception{

    String message;

    public TreeException(){

    }

    public TreeException(String message){
        super(message);
        this.message=message;
    }
}
