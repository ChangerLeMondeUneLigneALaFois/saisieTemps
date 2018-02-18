package org.free.software.fixtures;

import org.free.software.model.travailleurs.NomComplet;
import org.free.software.model.travailleurs.Travailleur;

/**
 * Created by Freak on 18/02/2018.
 */
public class TravailleurFixture {

    public Travailleur randomTravailleur() {
        return new Travailleur(identifiantTravailleur, new NomComplet("travailleur", "libre"));
    }
}
