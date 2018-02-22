package org.free.software.model.feuilleDeTemps.usecases;

import io.vavr.Tuple2;
import org.free.software.model.feuilleDeTemps.evenements.OrdonnanceurFeuillesDeTemps;
import org.free.software.model.temps.MoisTravailleur;
import org.free.software.model.temps.ContratClient;
import org.free.software.model.feuilleDeTemps.evenements.TempsDeclare;
import org.free.software.model.feuilleDeTemps.recuperation.RecuperationFeuilleDeTemps;
import org.free.software.model.feuilleDeTemps.FeuilleDeTemps;

import java.time.YearMonth;

/**
 * Created by Freak on 18/02/2018.
 */
public class DeclarationTemps {

    private RecuperationFeuilleDeTemps recuperationFeuilleDeTemps;
    private OrdonnanceurFeuillesDeTemps ordonnanceurFeuillesDeTemps;

    public DeclarationTemps(RecuperationFeuilleDeTemps recuperationFeuilleDeTemps, OrdonnanceurFeuillesDeTemps ordonnanceurFeuillesDeTemps) {
        this.recuperationFeuilleDeTemps = recuperationFeuilleDeTemps;
        this.ordonnanceurFeuillesDeTemps = ordonnanceurFeuillesDeTemps;
    }

    public FeuilleDeTemps declarerUnTempsPlein(ContratClient contratClient, YearMonth month) {
        FeuilleDeTemps feuilleDeTemps = recuperationFeuilleDeTemps.trouverParTravailleurEtMois(new MoisTravailleur(month, contratClient.getTravailleur().getIdentiteTravailleur()));
        Tuple2<FeuilleDeTemps, TempsDeclare> tempsDeclare = feuilleDeTemps.declarerTempsPlein(contratClient.getClient());
        ordonnanceurFeuillesDeTemps.executer(tempsDeclare._2);
        return tempsDeclare._1;
    }
}
