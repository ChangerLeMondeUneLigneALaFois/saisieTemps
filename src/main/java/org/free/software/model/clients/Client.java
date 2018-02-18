package org.free.software.model.clients;

/**
 * Created by Freak on 17/02/2018.
 */
public class Client {
    private final NomClient nomClient;
    private final IdentifiantClient identifiant;

    public Client(NomClient nomClient, IdentifiantClient identifiant) {
        this.nomClient = nomClient;
        this.identifiant = identifiant;
    }

    public IdentifiantClient getIdentifiant() {
        return identifiant;
    }
}
