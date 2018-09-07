/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tEventBasedGatewayType")
@XmlEnum
public enum EventBasedGatewayType {

    @XmlEnumValue("Exclusive")
    EXCLUSIVE("Exclusive"),
    @XmlEnumValue("Parallel")
    PARALLEL("Parallel");
    private final String value;

    EventBasedGatewayType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventBasedGatewayType fromValue(String v) {
        for (EventBasedGatewayType c: EventBasedGatewayType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
