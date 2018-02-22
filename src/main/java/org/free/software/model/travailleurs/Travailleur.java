package org.free.software.model.travailleurs;

/**
 * Created by Freak on 17/02/2018.
 */
public class Travailleur {
    private final IdentiteTravailleur identiteTravailleur;
    private final NomComplet nomComplet;

    public Travailleur(IdentiteTravailleur identiteTravailleur, NomComplet nomComplet) {
        this.identiteTravailleur = identiteTravailleur;
        this.nomComplet = nomComplet;
    }

    public IdentiteTravailleur getIdentiteTravailleur() {
        return identiteTravailleur;
    }
}
