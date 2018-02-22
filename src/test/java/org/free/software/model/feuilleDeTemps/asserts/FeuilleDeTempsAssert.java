package org.free.software.model.feuilleDeTemps.asserts;

import org.assertj.core.api.AbstractAssert;
import org.free.software.model.clients.Client;
import org.free.software.model.feuilleDeTemps.FeuilleDeTemps;
import org.free.software.model.temps.MoisAnnee;

public class FeuilleDeTempsAssert extends AbstractAssert<FeuilleDeTempsAssert, FeuilleDeTemps> {

  public FeuilleDeTempsAssert(FeuilleDeTemps actual) {
    super(actual, FeuilleDeTempsAssert.class);
  }

  public static FeuilleDeTempsAssert assertThat(FeuilleDeTemps actual) {
    return new FeuilleDeTempsAssert(actual);
  }

  public FeuilleDeTempsAssert aTravailleSeulementChez(Client client) {
    isNotNull();

    if (!actual.nombreDeJoursPassesChez(client).equals(actual.tempsPasse())) {
      failWithMessage("Le travailleur a passé seulement <%s> jours chez le client alors qu'on s'attendait à <%s>", actual.nombreDeJoursPassesChez(client), actual.tempsPasse());
    }

    return this;
  }

  public FeuilleDeTempsAssert estComplet() {
    isNotNull();

    if (!actual.estComplete()) {
      failWithMessage("Cette feuille de temps n'est pas complete, il manque <%s> jours sur les <%s> jours que comporte le mois", actual.nombreDeJoursManquants(), MoisAnnee.nombreDeJoursDansUnMois(actual.getMoisTravailleur().getMois()).size());
    }

    return this;
  }
}