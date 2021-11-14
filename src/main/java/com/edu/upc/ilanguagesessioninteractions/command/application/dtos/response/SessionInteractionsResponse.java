package com.edu.upc.ilanguagesessioninteractions.command.application.dtos.response;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class SessionInteractionsResponse {
    String sessionInteractionId;
    LocalDateTime initialDate;
    LocalDateTime finalDate;
    String sessionId;
    String externalToolId;
}
