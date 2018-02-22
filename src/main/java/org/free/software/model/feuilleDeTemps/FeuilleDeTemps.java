package org.free.software.model.feuilleDeTemps;

import io.vavr.Tuple2;
import org.free.software.model.clients.Client;
import org.free.software.model.temps.JoursTravail;
import org.free.software.model.temps.MoisAnnee;
import org.free.software.model.temps.MoisTravailleur;
import org.free.software.model.feuilleDeTemps.evenements.TempsDeclare;
import org.free.software.model.travailleurs.Travailleur;

import java.time.YearMonth;

/**
 * Created by Freak on 17/02/2018.
 */
public class FeuilleDeTemps {

    private YearMonth mois;
    private final IdentifiantFeuilleDeTemps identifiant;
    private final JoursTravail joursTravail;
    private final Travailleur travailleur;

    public FeuilleDeTemps(Travailleur travailleur, YearMonth mois, IdentifiantFeuilleDeTemps identifiant) {
        this.travailleur = travailleur;
        this.mois = mois;
        this.identifiant = identifiant;
        joursTravail = new JoursTravail();
    }

    public FeuilleDeTemps(Travailleur travailleur, YearMonth mois, IdentifiantFeuilleDeTemps identifiant, JoursTravail joursTravail) {
        this.travailleur = travailleur;
        this.mois = mois;
        this.identifiant = identifiant;
        this.joursTravail = joursTravail;
    }

    public Integer nombreDeJoursPassesChez(Client client) {
        return joursTravail.nombreDeJoursPassesChez(client);
    }

    public Integer tempsPasse() {
        return joursTravail.nombreDeJoursTotal();
    }

    public boolean estComplete() {
        return false;
    }

    public Integer nombreDeJoursManquants() {
        return MoisAnnee.nombreDeJoursDansUnMois(mois).size() - tempsPasse();
    }

    public Tuple2<FeuilleDeTemps, TempsDeclare> declarerTempsPlein(Client client) {
        JoursTravail joursTravail = new JoursTravail(mois, client);
        TempsDeclare tempsDeclare = new TempsDeclare(this, joursTravail, client);
        return new Tuple2<>(this.declarerJoursTravail(joursTravail), tempsDeclare);
    }

    public FeuilleDeTemps declarerJoursTravail(JoursTravail joursTravail) {
        return new FeuilleDeTemps(this.travailleur, this.mois, this.identifiant, joursTravail);
    }

    public IdentifiantFeuilleDeTemps getIdentifiant() {
        return identifiant;
    }

    public MoisTravailleur getMoisTravailleur() {
        return new MoisTravailleur(mois, travailleur.getIdentiteTravailleur());
    }
}
