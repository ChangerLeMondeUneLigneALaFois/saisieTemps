package org.free.software.fixtures;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Freak on 18/02/2018.
 */
public class MonthFixture {
    public YearMonth randomMonthOfCurrentYear() {
        return YearMonth.of(LocalDateTime.now().getYear(), Month.of(ThreadLocalRandom.current().nextInt(1, 12 + 1)));
    }
}
