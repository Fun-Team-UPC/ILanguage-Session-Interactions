package com.edu.upc.ilanguagesessioninteractions.command.application.dtos;

public class SessionInteractionsErrorResponse {
    private String message;

    public SessionInteractionsErrorResponse() {
        this.message = "Error assigning a external tool to session";
    }

    public String getMessage() {
        return message;
    }
}
