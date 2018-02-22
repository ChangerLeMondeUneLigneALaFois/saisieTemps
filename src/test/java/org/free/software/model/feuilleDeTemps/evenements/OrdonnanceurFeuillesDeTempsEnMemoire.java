package org.free.software.model.feuilleDeTemps.evenements;

import org.free.software.model.feuilleDeTemps.stockage.StockageFeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.recuperation.RecuperationFeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.FeuilleDeTemps;

/**
 * Created by Freak on 18/02/2018.
 */
public class OrdonnanceurFeuillesDeTempsEnMemoire implements OrdonnanceurFeuillesDeTemps {
    private RecuperationFeuilleDeTemps recuperationFeuilleDeTemps;
    private StockageFeuilleDeTemps stockageFeuilleDeTemps;

    public OrdonnanceurFeuillesDeTempsEnMemoire(RecuperationFeuilleDeTemps recuperationFeuilleDeTemps, StockageFeuilleDeTemps stockageFeuilleDeTemps) {
        this.recuperationFeuilleDeTemps = recuperationFeuilleDeTemps;
        this.stockageFeuilleDeTemps = stockageFeuilleDeTemps;
    }

    @Override
    public void executer(TempsDeclare tempsDeclare) {
        FeuilleDeTemps feuilleDeTemps = recuperationFeuilleDeTemps.trouverParIdentifiant(tempsDeclare.getIdentifiantFeuilleDeTemps());
        stockageFeuilleDeTemps.stocker(feuilleDeTemps.declarerJoursTravail(tempsDeclare.getJoursTravail()));
    }
}
