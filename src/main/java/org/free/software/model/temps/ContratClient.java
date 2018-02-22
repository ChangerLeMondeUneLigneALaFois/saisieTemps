package org.free.software.model.temps;

import org.free.software.model.clients.Client;
import org.free.software.model.travailleurs.Travailleur;

/**
 * Created by Freak on 19/02/2018.
 */
public class ContratClient {
    private final Travailleur travailleur;
    private final Client client;

    public ContratClient(Travailleur travailleur, Client client) {

        this.travailleur = travailleur;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public Travailleur getTravailleur() {
        return travailleur;
    }
}
