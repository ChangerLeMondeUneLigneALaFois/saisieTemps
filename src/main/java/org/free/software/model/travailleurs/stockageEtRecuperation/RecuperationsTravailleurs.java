package org.free.software.model.travailleurs.stockageEtRecuperation;

import org.free.software.model.travailleurs.IdentiteTravailleur;
import org.free.software.model.travailleurs.Travailleur;

/**
 * Created by Freak on 19/02/2018.
 */
public interface RecuperationsTravailleurs {
    Travailleur trouverParIdentifiant(IdentiteTravailleur identiteTravailleur);
}
