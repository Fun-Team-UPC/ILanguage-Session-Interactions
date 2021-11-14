package com.edu.upc.ilanguagesessioninteractions.command.application.services;

import com.edu.upc.ilanguagesessioninteractions.command.application.dtos.request.SessionInteracionsRequest;
import com.edu.upc.ilanguagesessioninteractions.command.application.dtos.response.SessionInteractionsResponse;
import com.edu.upc.ilanguagesessioninteractions.command.application.validators.AssignSessionInteractionsValidator;
import com.edu.upc.ilanguagesessioninteractions.command.infra.SessionInteractionsInfraRepository;
import commands.AssignInteractionToSession;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;
import pe.com.ilanguage.common.application.Notification;
import pe.com.ilanguage.common.application.Result;
import pe.com.ilanguage.common.application.ResultType;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
@AllArgsConstructor
public class SessionInteractionsApplicationService {
    private final CommandGateway commandGateway;
    private final SessionInteractionsInfraRepository _repository;
    private final AssignSessionInteractionsValidator validator;

    public Result<SessionInteractionsResponse, Notification> assign(SessionInteracionsRequest request) throws Exception{
        Notification notification = this.validator.validate(request);
        if (notification.hasErrors()){
            return Result.failure(notification);
        }
        String sessionInteractionsId = UUID.randomUUID().toString();
        AssignInteractionToSession assignInteractionToSession = new AssignInteractionToSession(
                sessionInteractionsId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                request.getSessionId(),
                request.getExternalToolId()
        );

        CompletableFuture<Object> future = commandGateway.send(assignInteractionToSession);
        CompletableFuture<ResultType> futureResult = future.handle((ok,ex) -> (ex!= null)? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = futureResult.get();
        if(resultType == ResultType.FAILURE){
            throw new Exception();
        }

        SessionInteractionsResponse response = new SessionInteractionsResponse(
                assignInteractionToSession.getSessionInteractionId(),
                assignInteractionToSession.getInitialDate(),
                assignInteractionToSession.getFinalDate(),
                assignInteractionToSession.getSessionId(),
                assignInteractionToSession.getExternalToolId()
        );
        return Result.success(response);
    }
}
