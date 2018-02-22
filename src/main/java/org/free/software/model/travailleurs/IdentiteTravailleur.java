package org.free.software.model.travailleurs;

/**
 * Created by Freak on 18/02/2018.
 */
public class IdentiteTravailleur {
    private NomComplet nomComplet;
    private DateNaissance dateNaissance;

    public IdentiteTravailleur(NomComplet nomComplet, DateNaissance dateNaissance) {
        this.nomComplet = nomComplet;
        this.dateNaissance = dateNaissance;
    }
}
