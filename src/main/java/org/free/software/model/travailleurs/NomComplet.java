package org.free.software.model.travailleurs;

/**
 * Created by Freak on 18/02/2018.
 */
public class NomComplet {
    private final String prenom;
    private final String nom;

    public NomComplet(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}
