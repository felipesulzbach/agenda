package br.com.felipe.agenda.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by felipe on 19/01/2017.
 */
public class SqlUtil {

    private SqlUtil() {}

    public static enum ClausulaEnum {
        AND("AND"),
        OR("OR");

        private final String value;

        ClausulaEnum(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static String[] retornarValorFiltros(final Object ...params) {
        final List<String> strList = new ArrayList<String>();
        for (Object param: params) {
            if (param == null) {
                break;
            }
            strList.add(param.toString());
        }

        if (strList.size() == 0) {
            return null;
        } else {
            return strList.toArray(new String[strList.size()]);
        }
    }

    public static String retornarFiltros(final Map<String, ClausulaEnum> filtros) {
        if (filtros == null || filtros.isEmpty()) {
            return null;
        }

        StringBuilder retorno = new StringBuilder();
        final List<String> strList = new ArrayList<String>();
        for (final String filtro : filtros.keySet()) {
            if (retorno.length() > 0) {
                retorno.append(" ");
                retorno.append(filtros.get(filtro));
                retorno.append(" ");
            }
            retorno.append(filtro);
            retorno.append(" = ?");
        }

        return retorno.toString();
    }
}
