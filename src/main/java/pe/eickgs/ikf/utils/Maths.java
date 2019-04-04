package pe.eickgs.ikf.utils;

import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
public class Maths {

    public static double average(List<Integer> values) {
        Assert.notEmpty(values, "Necesita ingresar una lista no vacia de datos");
        int sum = values.stream().mapToInt(Integer::intValue).sum();
        return (double) sum / values.size();
    }

    public static double variance(List<Integer> values) {
        Assert.notEmpty(values, "Necesita ingresar una lista no vacia de datos");
        double average = average(values);
        double variance = 0.0;

        for (int value : values) {
            variance += Math.pow(value - average, 2f);
        }
        return variance / values.size();
    }

    public static double deviationStd(List<Integer> values) {
        Assert.notEmpty(values, "Necesita ingresar una lista no vacia de datos");
        return Math.sqrt(variance(values));
    }
}
