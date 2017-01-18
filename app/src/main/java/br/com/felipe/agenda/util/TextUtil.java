package br.com.felipe.agenda.util;

import java.text.Normalizer;

/**
 * Created by felipe on 15/01/2017.
 */
public class TextUtil {

    private TextUtil() {}

    public static String returnOnlyNumbers(final String str) {
        if (str != null) {
            return str.replaceAll("[^0-9]", "");
        } else {
            return str;
        }
    }

    public static String returnOnlyLetters(final String str) {
        if (str != null) {
            return str.replaceAll("[^0-9]", "");
        } else {
            return str;
        }
    }

    public static String addZerosInFront(String number, int digits) {
        if (number != null && !number.trim().isEmpty()) {
            final StringBuilder strB = new StringBuilder();
            strB.append("%0");
            strB.append(digits);
            strB.append("d");
            return String.format(strB.toString(), Long.valueOf(number));
        } else {
            return null;
        }
    }

    public static String removeLeadingZeros(final String str) {
        if (str == null) {
            return null;
        }
        return Long.valueOf(str).toString();
    }

    public static String normalizeSpaces(final String str) {
        if (str == null) {
            return null;
        }
        return (str.trim()).replaceAll("\\s+", " ");
    }

    public static String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
