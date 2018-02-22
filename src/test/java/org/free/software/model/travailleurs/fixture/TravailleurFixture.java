package org.free.software.model.travailleurs.fixture;

import org.free.software.model.travailleurs.DateNaissance;
import org.free.software.model.travailleurs.IdentiteTravailleur;
import org.free.software.model.travailleurs.NomComplet;
import org.free.software.model.travailleurs.Travailleur;
import org.free.software.model.travailleurs.stockageEtRecuperation.StockageEtRecuperationTravailleursEnMemoire;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Created by Freak on 18/02/2018.
 */
public class TravailleurFixture {

    public Travailleur travailleurAleatoire(StockageEtRecuperationTravailleursEnMemoire travailleurDatabase) {
        NomComplet nomComplet = new NomComplet("travailleur", "libre");
        IdentiteTravailleur identiteTravailleur = new IdentiteTravailleur(nomComplet, new DateNaissance(LocalDate.of(1975, 12, 3)));
        travailleurDatabase.stocker(new Travailleur(identiteTravailleur, nomComplet));
        return new Travailleur(identiteTravailleur, nomComplet);
    }
}
