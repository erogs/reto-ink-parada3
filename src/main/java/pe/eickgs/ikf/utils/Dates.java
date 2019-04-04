package pe.eickgs.ikf.utils;

import java.time.LocalDate;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
public class Dates {

    public static LocalDate add(LocalDate target, Double plus) {
        int addYears = plus.intValue();
        plus = (plus - addYears) * 12;
        int addMonths = plus.intValue();
        plus = (plus - addMonths) * 30;
        int addDays = plus.intValue();
        return target.plusYears(addYears).plusMonths(addMonths).plusDays(addDays);
    }
}
