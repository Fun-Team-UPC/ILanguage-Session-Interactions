package com.edu.upc.ilanguagesessioninteractions.command.application.handlers;

import com.edu.upc.ilanguagesessioninteractions.command.infra.SessionInteractionsInfra;
import com.edu.upc.ilanguagesessioninteractions.command.infra.SessionInteractionsInfraRepository;
import events.SessionInteractionsAssigned;
import org.axonframework.eventhandling.EventHandler;

public class SessionInteractionsEventHandler {
    private final SessionInteractionsInfraRepository sessionInteractionsInfraRepository;

    public SessionInteractionsEventHandler(SessionInteractionsInfraRepository sessionInteractionsInfraRepository) {
        this.sessionInteractionsInfraRepository = sessionInteractionsInfraRepository;
    }

    @EventHandler
    public void on (SessionInteractionsAssigned event){
        sessionInteractionsInfraRepository.save(new SessionInteractionsInfra(event.getSessionInteractionId(), event.getSessionId(), event.getExternalToolId()));
    }
}
