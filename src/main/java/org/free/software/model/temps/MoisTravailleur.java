package org.free.software.model.temps;

import org.free.software.model.travailleurs.IdentiteTravailleur;
import org.free.software.model.travailleurs.Travailleur;

import java.time.YearMonth;

/**
 * Created by Freak on 18/02/2018.
 */
public class MoisTravailleur {
    YearMonth mois;
    IdentiteTravailleur travailleur;

    public MoisTravailleur(YearMonth mois, IdentiteTravailleur travailleur) {
        this.mois = mois;
        this.travailleur = travailleur;
    }

    public YearMonth getMois() {
        return mois;
    }

    public IdentiteTravailleur getIdentiteTravailleur() {
        return travailleur;
    }
}
