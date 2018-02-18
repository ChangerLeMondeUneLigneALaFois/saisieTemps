package org.free.software.model.temps.events;

import org.free.software.model.clients.Client;
import org.free.software.model.clients.IdentifiantClient;
import org.free.software.model.temps.FeuilleDeTemps;
import org.free.software.model.temps.IdentifiantFeuilleDeTemps;
import org.free.software.model.temps.Temps;

/**
 * Created by Freak on 18/02/2018.
 */
public class TempsDeclare {

    private final IdentifiantFeuilleDeTemps identifiantFeuilleDeTemps;
    private final IdentifiantClient identifiantClient;
    private final Temps temps;

    public TempsDeclare(FeuilleDeTemps feuilleDeTemps, Temps temps, Client identifiantClient) {
        this.identifiantClient = identifiantClient.getIdentifiant();
        this.temps = temps;
        identifiantFeuilleDeTemps = feuilleDeTemps.getIdentifiant();
    }
}
