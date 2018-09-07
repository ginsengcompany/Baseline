/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tMultiInstanceFlowCondition")
@XmlEnum
public enum MultiInstanceFlowCondition {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("One")
    ONE("One"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Complex")
    COMPLEX("Complex");
    private final String value;

    MultiInstanceFlowCondition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultiInstanceFlowCondition fromValue(String v) {
        for (MultiInstanceFlowCondition c: MultiInstanceFlowCondition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
