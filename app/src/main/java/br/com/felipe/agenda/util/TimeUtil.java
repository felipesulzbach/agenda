package br.com.felipe.agenda.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by felipe on 15/01/2017.
 */
public class TimeUtil {

    private TimeUtil() {}

    public static enum DateEnum {

        DATE_BR("dd/MM/yyyy"),
        DATE_HOURMIN_BR("dd/MM/yyyy HH:mm"),
        DATE_HOURMINSEC_BR("dd/MM/yyyy HH:mm:ss"),
        HOURMINSEC_BR("HH:mm:ss");

        private final String value;

        DateEnum(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public static XMLGregorianCalendar dateToXMLGregorianCalendar(final Date data) throws Exception {
        if (data == null) {
            return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }

    public static Date xMLGregorianCalendarToDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

    public static Date dateToDateFormat(final Date data, final DateEnum format) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat(format.getValue());
        return dateFormat.parse(dateFormat.format(data));
    }

    public static String dateToString(final Date data, final DateEnum format) throws Exception {
        final DateFormat outputFormat = new SimpleDateFormat(format.getValue());
        return outputFormat.format(data);
    }

    public static Date stringToDate(final String data, final DateEnum format) throws Exception {
        final DateFormat outputFormat = new SimpleDateFormat(format.getValue());
        return outputFormat.parse(data);
    }

    public static Timestamp stringToTimeStamp(final String data, final DateEnum format) throws Exception {
        final DateFormat outputFormat = new SimpleDateFormat(format.getValue());
        final Date date = outputFormat.parse(data);
        return new Timestamp(date.getTime());
    }

    public static boolean isSameDay(final Date date1, final Date date2) throws Exception {
        return date1.compareTo(date2) == 0;
    }

    public static boolean isEqualsOrLessDateHourMinute(final Date date1, final Date date2) throws Exception {
        return removeSecondAndMillisecound(date1).compareTo(removeSecondAndMillisecound(date2)) == 0
                || removeSecondAndMillisecound(date1).compareTo(removeSecondAndMillisecound(date2)) == -1;
    }

    public static boolean isEqualOrGreaterDateHourMinute(final Date date1, final Date date2) throws Exception {
        return removeSecondAndMillisecound(date1).compareTo(removeSecondAndMillisecound(date2)) == 0
                || removeSecondAndMillisecound(date1).compareTo(removeSecondAndMillisecound(date2)) == 1;
    }

    public static boolean isFirstGreaterDateHourMinute(final Date date1, final Date date2) throws Exception {
        return removeSecondAndMillisecound(date1).compareTo(removeSecondAndMillisecound(date2)) == 1;
    }

    public static boolean isFirstLessDateHourMinute(final Date date1, final Date date2) throws Exception {
        return removeSecondAndMillisecound(date1).compareTo(removeSecondAndMillisecound(date2)) == -1;
    }

    public static Date removeHourMinuteSecondAndMillisecound(Date data) throws Exception {
        return dateToDateFormat(data, DateEnum.DATE_BR);
    }

    public static Date removeSecondAndMillisecound(final Date date) throws Exception {
        return dateToDateFormat(date, DateEnum.DATE_HOURMIN_BR);
    }
}
