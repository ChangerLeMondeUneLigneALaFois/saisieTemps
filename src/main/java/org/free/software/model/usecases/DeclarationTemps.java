package org.free.software.model.usecases;

import io.vavr.Tuple2;
import org.free.software.model.clients.Client;
import org.free.software.model.events.OrdonnanceurFeuillesDeTemps;
import org.free.software.model.temps.MoisTravailleur;
import org.free.software.model.temps.events.TempsDeclare;
import org.free.software.model.repositories.FeuillesDeTemps;
import org.free.software.model.temps.FeuilleDeTemps;
import org.free.software.model.travailleurs.Travailleur;

import java.time.YearMonth;

/**
 * Created by Freak on 18/02/2018.
 */
public class DeclarationTemps {

    private FeuillesDeTemps nosFeuillesDeTemps;
    private OrdonnanceurFeuillesDeTemps ordonnanceurFeuillesDeTemps;

    public DeclarationTemps(FeuillesDeTemps nosFeuillesDeTemps, OrdonnanceurFeuillesDeTemps ordonnanceurFeuillesDeTemps) {
        this.nosFeuillesDeTemps = nosFeuillesDeTemps;
        this.ordonnanceurFeuillesDeTemps = ordonnanceurFeuillesDeTemps;
    }

    public FeuilleDeTemps declarerUnTempsPlein(Travailleur travailleur, Client client, YearMonth month) {
        FeuilleDeTemps feuilleDeTemps = nosFeuillesDeTemps.trouverParTravailleurEtMois(new MoisTravailleur(month, travailleur));
        Tuple2<FeuilleDeTemps, TempsDeclare> tempsDeclare = feuilleDeTemps.declarerTempsPlein(client);
        ordonnanceurFeuillesDeTemps.executer(tempsDeclare._2);
        return tempsDeclare._1;
    }
}
