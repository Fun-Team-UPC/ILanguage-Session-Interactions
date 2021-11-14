package com.edu.upc.ilanguagesessioninteractions.command.infra.proyections;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExternalToolInfra {
    @Id
    public String externalToolId;
    @Column(length=20)
    public String name;
    @Column(length=20)
    public String description;
    @Column(length=20)
    public String resource;
    private Instant createdAt;
    @Column(nullable = true)
    private Instant updatedAt;

    public ExternalToolInfra(String externalToolId, String name, String description, String resource, Instant createdAt) {
        this.externalToolId = externalToolId;
        this.name = name;
        this.description = description;
        this.resource = resource;
        this.createdAt = createdAt;
    }
}
