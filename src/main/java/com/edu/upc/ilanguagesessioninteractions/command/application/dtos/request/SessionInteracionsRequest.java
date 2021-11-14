package com.edu.upc.ilanguagesessioninteractions.command.application.dtos.request;

import lombok.Getter;

@Getter
public class SessionInteracionsRequest {
    private String sessionInteractionId;
    private String sessionId;
    private String externalToolId;
}
