package org.free.software.model.feuilleDeTemps.usecases;


import io.vavr.Tuple2;
import org.free.software.model.clients.fixtures.ClientFixture;
import org.free.software.model.temps.fixtures.MonthFixture;
import org.free.software.model.travailleurs.fixture.TravailleurFixture;
import org.free.software.model.clients.Client;
import org.free.software.model.feuilleDeTemps.evenements.OrdonnanceurFeuillesDeTempsEnMemoire;
import org.free.software.model.feuilleDeTemps.stockageEtRecuperation.StockageEtRecuperationFeuilleDeTempsEnMemoire;
import org.free.software.model.temps.ContratClient;
import org.free.software.model.feuilleDeTemps.FeuilleDeTemps;
import org.free.software.model.temps.MoisTravailleur;
import org.free.software.model.travailleurs.Travailleur;
import org.free.software.model.travailleurs.stockageEtRecuperation.StockageEtRecuperationTravailleursEnMemoire;
import org.junit.Before;
import org.junit.Test;

import java.time.YearMonth;

import static org.free.software.model.feuilleDeTemps.asserts.FeuilleDeTempsAssert.assertThat;

public class JePeuxDeclarerDesTemps {

    private TravailleurFixture travailleurFixture;
    private ClientFixture clientFixture;
    private MonthFixture monthFixture;
    private DeclarationTemps declarationTemps;
    private StockageEtRecuperationFeuilleDeTempsEnMemoire feuillesDeTemps;
    private StockageEtRecuperationTravailleursEnMemoire travailleurs;

    @Before
    public void setUp() {
        travailleurFixture = new TravailleurFixture();
        clientFixture = new ClientFixture();
        monthFixture = new MonthFixture();
        travailleurs = new StockageEtRecuperationTravailleursEnMemoire();
        feuillesDeTemps = new StockageEtRecuperationFeuilleDeTempsEnMemoire(travailleurs);
        declarationTemps = new DeclarationTemps(feuillesDeTemps, new OrdonnanceurFeuillesDeTempsEnMemoire(feuillesDeTemps, feuillesDeTemps));
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
        Travailleur travailleur = travailleurFixture.travailleurAleatoire(travailleurs);
        Client client = clientFixture.clientAleatoire();
        YearMonth moisAnnee = monthFixture.moisDeLAnneeAleatoire();
        declarationTemps.declarerUnTempsPlein(new ContratClient(travailleur, client), moisAnnee);
        return new Tuple2<>(new MoisTravailleur(moisAnnee, travailleur.getIdentiteTravailleur()), client);
    }

    private FeuilleDeTemps je_peux_obtenir_une_feuille_de_temps_pour(MoisTravailleur moisTravailleur) {
        return feuillesDeTemps.trouverParTravailleurEtMois(moisTravailleur);
    }
}
