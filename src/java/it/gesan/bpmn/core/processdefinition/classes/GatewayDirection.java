/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tGatewayDirection")
@XmlEnum
public enum GatewayDirection {

    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified"),
    @XmlEnumValue("Converging")
    CONVERGING("Converging"),
    @XmlEnumValue("Diverging")
    DIVERGING("Diverging"),
    @XmlEnumValue("Mixed")
    MIXED("Mixed");
    private final String value;

    GatewayDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GatewayDirection fromValue(String v) {
        for (GatewayDirection c: GatewayDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
