package org.free.software.model.feuilleDeTemps.recuperation;

import org.free.software.model.feuilleDeTemps.FeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.IdentifiantFeuilleDeTemps;
import org.free.software.model.temps.MoisTravailleur;

/**
 * Created by Freak on 18/02/2018.
 */
public interface RecuperationFeuilleDeTemps {
    FeuilleDeTemps trouverParTravailleurEtMois(MoisTravailleur moisTravailleur);

    FeuilleDeTemps trouverParIdentifiant(IdentifiantFeuilleDeTemps identifiantFeuilleDeTemps);
}
