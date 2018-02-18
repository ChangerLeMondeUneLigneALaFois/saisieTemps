package org.free.software.model.temps;

import io.vavr.Tuple2;
import org.free.software.model.clients.Client;
import org.free.software.model.temps.events.TempsDeclare;
import org.free.software.model.travailleurs.Travailleur;

/**
 * Created by Freak on 17/02/2018.
 */
public class FeuilleDeTemps {

    private final Travailleur travailleur;
    private final IdentifiantFeuilleDeTemps identifiant;

    public FeuilleDeTemps(Travailleur travailleur, IdentifiantFeuilleDeTemps identifiant) {
        this.travailleur = travailleur;
        this.identifiant = identifiant;
    }

    public Temps nombreDeJoursPassesChez(Client client) {
        return null;
    }

    public Temps tempsPasse() {
        return null;
    }

    public boolean estComplete() {
        return false;
    }

    public Temps nombreDeJoursManquants() {
        return null;
    }

    public Tuple2<FeuilleDeTemps, TempsDeclare> declarerTempsPlein(Client client) {
        return new Tuple2<>(this, new TempsDeclare(this, null, client));
    }

    public IdentifiantFeuilleDeTemps getIdentifiant() {
        return identifiant;
    }
}
