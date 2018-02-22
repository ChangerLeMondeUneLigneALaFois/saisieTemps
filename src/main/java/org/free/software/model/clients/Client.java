package org.free.software.model.clients;

import java.util.Objects;

/**
 * Created by Freak on 17/02/2018.
 */
public class Client {
    private final NomClient nomClient;
    private final IdentiteClient identifiant;

    public Client(NomClient nomClient, IdentiteClient identifiant) {
        this.nomClient = nomClient;
        this.identifiant = identifiant;
    }

    public IdentiteClient getIdentifiant() {
        return identifiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(identifiant, client.identifiant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant);
    }
}
