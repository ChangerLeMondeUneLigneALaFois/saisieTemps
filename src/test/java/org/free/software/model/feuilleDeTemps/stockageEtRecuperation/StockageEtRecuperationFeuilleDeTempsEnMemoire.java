package org.free.software.model.feuilleDeTemps.stockageEtRecuperation;

import org.free.software.model.feuilleDeTemps.FeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.IdentifiantFeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.recuperation.RecuperationFeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.stockage.StockageFeuilleDeTemps;
import org.free.software.model.temps.MoisTravailleur;
import org.free.software.model.travailleurs.Travailleur;
import org.free.software.model.travailleurs.stockageEtRecuperation.RecuperationsTravailleurs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Freak on 22/02/2018.
 */
public class StockageEtRecuperationFeuilleDeTempsEnMemoire implements StockageFeuilleDeTemps, RecuperationFeuilleDeTemps {

    public Map<MoisTravailleur, FeuilleDeTemps> feuillesDeTemps;
    private RecuperationsTravailleurs recuperationTravailleurs;

    // Intéressant : on explicite la dépendance conceptuelle entre FeuilleDeTemps et Travailleurs (implémenté sous forme de clé étrangère dans la plupart des SGBD)
    // FeuilleDeTemps est donc bien notre racine d'aggrégat.
    public StockageEtRecuperationFeuilleDeTempsEnMemoire(RecuperationsTravailleurs recuperationTravailleurs) {
        this.recuperationTravailleurs = recuperationTravailleurs;
        this.feuillesDeTemps = new HashMap<>();
    }

    @Override
    public void stocker(FeuilleDeTemps feuilleDeTemps) {
        this.feuillesDeTemps.put(feuilleDeTemps.getMoisTravailleur(), feuilleDeTemps);
    }

    @Override
    public FeuilleDeTemps trouverParTravailleurEtMois(MoisTravailleur moisTravailleur) {
        FeuilleDeTemps feuilleDeTemps = feuillesDeTemps.get(moisTravailleur);
        // Est-ce du métier ou de la technique : si une feuille de temps n'existe pas on la crée ?
        // Peut on créer automatiquement toutes les feuilles de temps pour les X prochaines années quand on crée un travailleur, ou les crée t'on à la volée comme ici ?
        if (feuilleDeTemps == null) {
            Travailleur travailleur = recuperationTravailleurs.trouverParIdentifiant(moisTravailleur.getIdentiteTravailleur());
            feuillesDeTemps.put(moisTravailleur, new FeuilleDeTemps(travailleur, moisTravailleur.getMois(), new IdentifiantFeuilleDeTemps(moisTravailleur)));
        }
        return feuillesDeTemps.get(moisTravailleur);
    }

    @Override
    public FeuilleDeTemps trouverParIdentifiant(IdentifiantFeuilleDeTemps identifiantFeuilleDeTemps) {
        return feuillesDeTemps
                .values()
                .stream()
                .filter(feuilleDeTemps -> feuilleDeTemps.getIdentifiant()
                        .equals(identifiantFeuilleDeTemps)).findFirst().orElseThrow(() -> new IllegalArgumentException("Identifiant de feuille de temps inconnu :" + identifiantFeuilleDeTemps));
    }
}
