package org.free.software.model.temps;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freak on 20/02/2018.
 */
public class MoisAnnee {
    public static List<LocalDate> nombreDeJoursDansUnMois(YearMonth yearMonth) {
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        LocalDate beginningOfMonth = YearMonth.from(endOfMonth.minusMonths(1)).atEndOfMonth().plusDays(1);
        LocalDate loop = beginningOfMonth;
        List<LocalDate> accumulator = new ArrayList<>();

        while (loop.isBefore(endOfMonth)) {
            loop = loop.plusDays(1);
            if (!(loop.getDayOfWeek().equals(DayOfWeek.SATURDAY) || loop.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
                accumulator.add(loop);
            }
        }
        return accumulator;
    }
}
