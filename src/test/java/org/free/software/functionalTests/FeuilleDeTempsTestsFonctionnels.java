package org.free.software.functionalTests;


import io.vavr.Tuple2;
import org.free.software.fixtures.ClientFixture;
import org.free.software.fixtures.MonthFixture;
import org.free.software.fixtures.TravailleurFixture;
import org.free.software.model.clients.Client;
import org.free.software.model.events.FakeFeuillesDeTempsEnMemoire;
import org.free.software.model.temps.FeuilleDeTemps;
import org.free.software.model.temps.MoisTravailleur;
import org.free.software.model.travailleurs.Travailleur;
import org.free.software.model.usecases.DeclarationTemps;
import org.junit.Before;
import org.junit.Test;

import java.time.YearMonth;

import static org.free.software.asserts.FeuilleDeTempsAssert.assertThat;

public class FeuilleDeTempsTestsFonctionnels {

    private TravailleurFixture travailleurFixture;
    private ClientFixture clientFixture;
    private MonthFixture monthFixture;
    private DeclarationTemps declarationTemps;

    @Before
    public void setUp() {
        travailleurFixture = new TravailleurFixture();
        clientFixture = new ClientFixture();
        monthFixture = new MonthFixture();

        declarationTemps = new DeclarationTemps(new FakeFeuillesDeTempsEnMemoire(), new FakeOrdonnanceurFeuillesDeTempsEnMemoire());
    }

    @Test
    public void je_peux_declarer_des_jours_de_travail() {
        Tuple2<MoisTravailleur, Client> travailleurEtClient = this.un_travailleur_a_travaille_tout_le_mois_courant_pour_un_client();

        FeuilleDeTemps workerActivitySheet = je_peux_obtenir_une_feuille_de_temps_pour(travailleurEtClient._1());
        assertThat(workerActivitySheet).aTravailleSeulementChez(travailleurEtClient._2);
        assertThat(workerActivitySheet).estComplet();
    }

    //TODO : Generate full time automatically at last known client
    //TODO : Generate full time automatically at unknown client if no client has ever been declared for person

    private Tuple2<MoisTravailleur, Client> un_travailleur_a_travaille_tout_le_mois_courant_pour_un_client() {
        Travailleur travailleur = travailleurFixture.randomTravailleur();
        Client client = clientFixture.randomTravailleur();
        YearMonth moisAnnee = monthFixture.randomMonthOfCurrentYear();
        declarationTemps.declarerUnTempsPlein(travailleur, client, moisAnnee);
        return new Tuple2<>(new MoisTravailleur(moisAnnee, travailleur), client);
    }

    private FeuilleDeTemps je_peux_obtenir_une_feuille_de_temps_pour(MoisTravailleur moisTravailleur) {
        return new FakeFeuillesDeTempsEnMemoire().trouverParTravailleurEtMois(moisTravailleur);
    }
}
