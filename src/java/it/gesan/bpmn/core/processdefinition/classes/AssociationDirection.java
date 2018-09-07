/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tAssociationDirection")
@XmlEnum
public enum AssociationDirection {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("One")
    ONE("One"),
    @XmlEnumValue("Both")
    BOTH("Both");
    private final String value;

    AssociationDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssociationDirection fromValue(String v) {
        for (AssociationDirection c: AssociationDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
