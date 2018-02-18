package org.free.software.model.events;

import org.free.software.model.temps.events.TempsDeclare;

/**
 * Created by Freak on 18/02/2018.
 */
public interface OrdonnanceurFeuillesDeTemps {
    void executer(TempsDeclare tempsDeclare);
}
