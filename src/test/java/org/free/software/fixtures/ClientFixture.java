package org.free.software.fixtures;

import org.free.software.model.clients.Client;
import org.free.software.model.clients.NomClient;

/**
 * Created by Freak on 18/02/2018.
 */
public class ClientFixture {

    public Client randomTravailleur() {
        return new Client(new NomClient("monMeilleurClient"), identifiant);
    }
}
