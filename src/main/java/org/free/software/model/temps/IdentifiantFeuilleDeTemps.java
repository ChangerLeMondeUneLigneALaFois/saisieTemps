package org.free.software.model.temps;

import org.free.software.model.travailleurs.IdentifiantTravailleur;

import java.time.YearMonth;

/**
 * Created by Freak on 18/02/2018.
 */
public class IdentifiantFeuilleDeTemps {

    private final String identifiantFeuilleDeTemps;

    public IdentifiantFeuilleDeTemps(IdentifiantTravailleur identifiantTravailleur, YearMonth moisAnnee) {
        identifiantFeuilleDeTemps = "Feuille de temps de " + identifiantTravailleur.toString() + " pour " + moisAnnee.toString();
    }
}
