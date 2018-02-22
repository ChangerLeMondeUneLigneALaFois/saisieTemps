package org.free.software.model.temps;

import org.free.software.model.clients.Client;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Freak on 18/02/2018.
 */
public class JoursTravail {

    private final List<JourneeTravail> journeeTravails;

    public JoursTravail() {
        journeeTravails = new ArrayList<>();
    }

    public JoursTravail(YearMonth mois, Client client) {
        journeeTravails = MoisAnnee.nombreDeJoursDansUnMois(mois).stream()
                .map(value -> new JourneeTravail(client, value))
                .collect(Collectors.toList());
    }

    public Integer nombreDeJoursPassesChez(Client client) {
        List<JourneeTravail> collect = journeeTravails.stream().filter(journeeTravail -> journeeTravail.wasSpentAt(client)).collect(Collectors.toList());
        return collect.size();
    }

    public Integer nombreDeJoursTotal() {
        return journeeTravails.size();
    }
}
