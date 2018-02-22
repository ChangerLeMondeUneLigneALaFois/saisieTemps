package org.free.software.model.feuilleDeTemps.evenements;

import org.free.software.model.clients.Client;
import org.free.software.model.clients.IdentiteClient;
import org.free.software.model.feuilleDeTemps.FeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.IdentifiantFeuilleDeTemps;
import org.free.software.model.temps.JoursTravail;

/**
 * Created by Freak on 18/02/2018.
 */
public class TempsDeclare {

    private final IdentifiantFeuilleDeTemps identifiantFeuilleDeTemps;
    private final IdentiteClient identiteClient;
    private final JoursTravail joursTravail;

    public TempsDeclare(FeuilleDeTemps feuilleDeTemps, JoursTravail joursTravail, Client identifiantClient) {
        this.identiteClient = identifiantClient.getIdentifiant();
        this.joursTravail = joursTravail;
        identifiantFeuilleDeTemps = feuilleDeTemps.getIdentifiant();
    }

    public IdentifiantFeuilleDeTemps getIdentifiantFeuilleDeTemps() {
        return identifiantFeuilleDeTemps;
    }

    public IdentiteClient getIdentiteClient() {
        return identiteClient;
    }

    public JoursTravail getJoursTravail() {
        return joursTravail;
    }
}
