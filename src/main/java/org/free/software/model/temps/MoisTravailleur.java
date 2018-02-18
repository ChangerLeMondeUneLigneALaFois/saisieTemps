package org.free.software.model.temps;

import org.free.software.model.travailleurs.Travailleur;

import java.time.YearMonth;

/**
 * Created by Freak on 18/02/2018.
 */
public class MoisTravailleur {
    YearMonth mois;
    Travailleur travailleur;

    public MoisTravailleur(YearMonth mois, Travailleur travailleur) {
        this.mois = mois;
        this.travailleur = travailleur;
    }
}
