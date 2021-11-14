package com.edu.upc.ilanguagesessioninteractions.command.application.validators;

import com.edu.upc.ilanguagesessioninteractions.command.application.dtos.request.SessionInteracionsRequest;
import com.edu.upc.ilanguagesessioninteractions.command.infra.SessionInteractionsInfraRepository;
import com.edu.upc.ilanguagesessioninteractions.command.infra.proyections.ExternalToolInfraRepository;
import org.springframework.stereotype.Component;
import pe.com.ilanguage.common.application.Notification;

@Component
public class AssignSessionInteractionsValidator {
    private final SessionInteractionsInfraRepository _repository;
    private final ExternalToolInfraRepository _externalToolInfraRepository;

    public AssignSessionInteractionsValidator(SessionInteractionsInfraRepository _repository, ExternalToolInfraRepository _externalToolInfraRepository) {
        this._repository = _repository;
        this._externalToolInfraRepository = _externalToolInfraRepository;
    }


    public Notification validate(SessionInteracionsRequest request) {
        Notification notification = new Notification();
        String userSubscriptionId = request.getSessionInteractionId().trim();
        if (userSubscriptionId.isEmpty()) {
            notification.addError("UserSubscriptionId IS REQUIRED");
        }
        String sessionId = request.getSessionId().trim();
        if (sessionId.isEmpty()) {
            notification.addError("Session id is required");
        }
        String externalToolId = request.getExternalToolId().trim();
        if (externalToolId.isEmpty()) {
            notification.addError("External Tool id is required");
        }

        var existingExternalTool = _externalToolInfraRepository.getById(externalToolId);
        if (existingExternalTool == null) {
            notification.addError("External Tool does not exists");
        }

        return notification;
    }
}
