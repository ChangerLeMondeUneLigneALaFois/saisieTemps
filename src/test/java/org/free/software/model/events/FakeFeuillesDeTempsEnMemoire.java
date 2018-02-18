package org.free.software.model.events;

import io.vavr.Tuple2;
import org.free.software.model.repositories.FeuillesDeTemps;
import org.free.software.model.temps.FeuilleDeTemps;
import org.free.software.model.temps.MoisTravailleur;
import org.free.software.model.travailleurs.Travailleur;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Freak on 18/02/2018.
 */
public class FakeFeuillesDeTempsEnMemoire implements FeuillesDeTemps {

    Map<MoisTravailleur, FeuilleDeTemps> feuillesDeTemps = new HashMap<>();

    @Override
    public FeuilleDeTemps trouverParTravailleurEtMois(MoisTravailleur moisTravailleur) {
        return feuillesDeTemps.get(moisTravailleur);
    }
}
