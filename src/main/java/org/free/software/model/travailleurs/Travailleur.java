package org.free.software.model.travailleurs;

/**
 * Created by Freak on 17/02/2018.
 */
public class Travailleur {
    private final IdentifiantTravailleur identifiantTravailleur;
    private final NomComplet nomComplet;

    public Travailleur(IdentifiantTravailleur identifiantTravailleur, NomComplet nomComplet) {
        this.identifiantTravailleur = identifiantTravailleur;
        this.nomComplet = nomComplet;
    }
}
