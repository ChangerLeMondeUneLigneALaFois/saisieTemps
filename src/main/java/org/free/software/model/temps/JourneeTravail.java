package org.free.software.model.temps;

import org.free.software.model.clients.Client;

import java.time.LocalDate;

/**
 * Created by Freak on 20/02/2018.
 */
public class JourneeTravail {
    private Client client;
    private LocalDate localDate;

    public JourneeTravail(Client client, LocalDate localDate) {
        this.client = client;
        this.localDate = localDate;
    }

    public boolean wasSpentAt(Client client) {
        return this.client.equals(client);
    }
}
