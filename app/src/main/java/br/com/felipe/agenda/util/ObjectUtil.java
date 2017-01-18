package br.com.felipe.agenda.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by felipe on 15/01/2017.
 */
public class ObjectUtil {

    private ObjectUtil() {}

    public static String objStringNull(final Object obj, final String retorno) {
        return obj == null ? retorno : obj.toString();
    }

    public static Long objLongNull(final Object obj, final Long retorno) {
        return obj == null ? retorno : Long.parseLong(obj.toString());
    }

    public static Date objDateNull(final Object obj, final Date retorno) {
        return obj == null ? retorno : (Date) obj;
    }

    public static Integer objIntegerNull(final Object obj, final Integer retorno) {
        return obj == null ? retorno : Integer.parseInt(obj.toString());
    }

    public static BigDecimal objBigDecimalNull(final Object obj, final BigDecimal retorno) {
        return obj == null ? retorno : new BigDecimal(obj.toString());
    }

    public static Timestamp objTimestampNull(final Object obj, final Timestamp retorno) {
        return obj == null ? retorno : (Timestamp) obj;
    }
}
