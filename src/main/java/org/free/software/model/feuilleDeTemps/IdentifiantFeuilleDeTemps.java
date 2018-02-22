package org.free.software.model.feuilleDeTemps;

import org.free.software.model.temps.MoisTravailleur;

import java.util.Objects;

/**
 * Created by Freak on 18/02/2018.
 */
public class IdentifiantFeuilleDeTemps {

    private final String identifiantFeuilleDeTemps;

    public IdentifiantFeuilleDeTemps(MoisTravailleur moisTravailleur) {
        identifiantFeuilleDeTemps = "Feuille de temps de " + moisTravailleur.getIdentiteTravailleur().toString() + " pour " + moisTravailleur.getMois().toString();
    }

    @Override
    public String toString() {
        return identifiantFeuilleDeTemps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifiantFeuilleDeTemps that = (IdentifiantFeuilleDeTemps) o;
        return Objects.equals(identifiantFeuilleDeTemps, that.identifiantFeuilleDeTemps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiantFeuilleDeTemps);
    }
}
