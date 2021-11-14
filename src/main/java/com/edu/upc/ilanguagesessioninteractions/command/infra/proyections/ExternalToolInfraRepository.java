package com.edu.upc.ilanguagesessioninteractions.command.infra.proyections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExternalToolInfraRepository extends JpaRepository<ExternalToolInfra, String> {
    @Query("SELECT s from ExternalToolInfra s WHERE s.name=?1")
    public ExternalToolInfra findByName(String subscriptionName);

    @Query("SELECT s from ExternalToolInfra s WHERE s.externalToolId=?1")
    public ExternalToolInfra getById(String subscriptionId);
}
