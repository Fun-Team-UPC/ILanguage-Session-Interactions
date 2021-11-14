package com.edu.upc.ilanguagesessioninteractions.command.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionInteractionsInfra {
    @Id
    public String SessionInteractionId;
    public String SessionId;
    public String ExternalToolId;
}
