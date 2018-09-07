/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tRelationshipDirection")
@XmlEnum
public enum RelationshipDirection {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Forward")
    FORWARD("Forward"),
    @XmlEnumValue("Backward")
    BACKWARD("Backward"),
    @XmlEnumValue("Both")
    BOTH("Both");
    private final String value;

    RelationshipDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelationshipDirection fromValue(String v) {
        for (RelationshipDirection c: RelationshipDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
