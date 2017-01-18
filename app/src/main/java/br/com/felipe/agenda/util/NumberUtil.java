package br.com.felipe.agenda.util;

import java.math.BigDecimal;

/**
 * Created by felipe on 15/01/2017.
 */
public class NumberUtil {

    private NumberUtil() {}

    public static String bigDecimalToString(final BigDecimal bd, final String retorno) {
        if (bd != null) {
            return (bd.toString()).replace(".", ",");
        } else {
            return retorno;
        }
    }

    public static Double bigDecimalToDouble(final BigDecimal bd, final Double retorno) {
        if (bd != null) {
            return bd.doubleValue();
        } else {
            return retorno;
        }
    }

    public static BigDecimal doubleToBigDecimal(final Double db, final BigDecimal retorno) {
        if (db != null) {
            return new BigDecimal(db);
        } else {
            return retorno;
        }
    }

    public static String integerToString(final Integer ing, final String retorno) {
        if (ing != null) {
            return ing.toString();
        } else {
            return retorno;
        }
    }

    public static Integer stringToInteger(final String st, final Integer retorno) {
        if (st != null) {
            return Integer.valueOf(st);
        } else {
            return retorno;
        }
    }

    public static String longToString(final Long lg, final String retorno) {
        if (lg != null) {
            return lg.toString();
        } else {
            return retorno;
        }
    }

    public static Long stringToLong(final String st, final Long retorno) {
        if (st != null) {
            return Long.valueOf(st);
        } else {
            return retorno;
        }
    }
}
