/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tProcessType")
@XmlEnum
public enum ProcessType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Public")
    PUBLIC("Public"),
    @XmlEnumValue("Private")
    PRIVATE("Private");
    private final String value;

    ProcessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcessType fromValue(String v) {
        for (ProcessType c: ProcessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
