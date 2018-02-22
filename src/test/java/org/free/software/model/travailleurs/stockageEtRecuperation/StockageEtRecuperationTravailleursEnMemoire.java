package org.free.software.model.travailleurs.stockageEtRecuperation;

import org.free.software.model.travailleurs.IdentiteTravailleur;
import org.free.software.model.travailleurs.Travailleur;
import org.free.software.model.travailleurs.stockage.StockageTravailleurs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Freak on 19/02/2018.
 */
public class StockageEtRecuperationTravailleursEnMemoire implements RecuperationsTravailleurs, StockageTravailleurs {

    private final Map<IdentiteTravailleur, Travailleur> travailleurs;

    public StockageEtRecuperationTravailleursEnMemoire() {
        this.travailleurs = new HashMap<>();
    }

    @Override
    public Travailleur trouverParIdentifiant(IdentiteTravailleur identiteTravailleur) {
        return travailleurs.get(identiteTravailleur);
    }

    @Override
    public void stocker(Travailleur travailleur) {
        travailleurs.put(travailleur.getIdentiteTravailleur(), travailleur);
    }
}
