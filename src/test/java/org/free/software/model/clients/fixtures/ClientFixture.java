package org.free.software.model.clients.fixtures;

import org.free.software.model.clients.Client;
import org.free.software.model.clients.IdentiteClient;
import org.free.software.model.clients.NomClient;
import org.free.software.model.clients.Siret;

/**
 * Created by Freak on 18/02/2018.
 */
public class ClientFixture {

    public Client clientAleatoire() {
        return new Client(new NomClient("monMeilleurClient"), new IdentiteClient(new Siret("siret")));
    }
}
