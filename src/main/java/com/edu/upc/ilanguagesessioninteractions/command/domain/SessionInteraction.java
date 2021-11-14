package com.edu.upc.ilanguagesessioninteractions.command.domain;

import commands.AssignInteractionToSession;
import events.SessionInteractionsAssigned;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.Instant;
import java.time.LocalDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@NoArgsConstructor
@AllArgsConstructor
@Aggregate
public class SessionInteraction {
    @AggregateIdentifier
    private String sessionInteractionId;
    private LocalDateTime initialDate;
    private LocalDateTime finalDate;
    private String sessionId;
    private String externalToolId;

    @CommandHandler
    public SessionInteraction(AssignInteractionToSession assignInteractionToSession){
        Instant now = Instant.now();
        apply(new SessionInteractionsAssigned(
                assignInteractionToSession.getSessionInteractionId(),
                assignInteractionToSession.getInitialDate(),
                assignInteractionToSession.getFinalDate(),
                assignInteractionToSession.getSessionId(),
                assignInteractionToSession.getExternalToolId()));
    }

    @EventSourcingHandler
    public void on(SessionInteractionsAssigned event){
        this.sessionInteractionId = event.getSessionInteractionId();
        this.finalDate = event.getFinalDate();
        this.initialDate = event.getInitialDate();
        this.sessionId = event.getSessionId();
        this.externalToolId = event.getExternalToolId();
    }
}
