package br.com.felipe.agenda.util;

/**
 *
 * Created by felipe on 07/02/2017.
 */
public enum PerifericoEnum {

    CAMERA("Câmera", 1);

    private final String label;
    private final String value;

    PerifericoEnum(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

}
