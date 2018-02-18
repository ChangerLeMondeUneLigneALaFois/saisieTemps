package org.free.software.asserts;

import org.assertj.core.api.AbstractAssert;
import org.free.software.model.clients.Client;
import org.free.software.model.temps.FeuilleDeTemps;

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
      failWithMessage("Cette feuille de temps n'est pas complete, il manque <%s> sur un total de <%s>", actual.nombreDeJoursManquants(), actual.tempsPasse());
    }

    return this;
  }
}