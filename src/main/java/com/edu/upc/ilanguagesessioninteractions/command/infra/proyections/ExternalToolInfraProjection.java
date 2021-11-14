package com.edu.upc.ilanguagesessioninteractions.command.infra.proyections;

import contracts.events.ExternalToolRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ExternalToolInfraProjection {
    private final ExternalToolInfraRepository externalToolInfraRepository;

    public ExternalToolInfraProjection(ExternalToolInfraRepository externalToolInfraRepository) {
        this.externalToolInfraRepository = externalToolInfraRepository;
    }

    @EventHandler
    public void on (ExternalToolRegistered event, @Timestamp Instant timestamp){
        ExternalToolInfra sessionInfra = new ExternalToolInfra(
                event.getExternalToolId(),
                event.getName(),
                event.getDescription(),
                event.getResource(),
                event.getOccurredOn());
        externalToolInfraRepository.save(sessionInfra);
    }
}
