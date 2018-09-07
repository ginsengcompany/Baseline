/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tMessageIntegrationDirection", namespace = "http://www.catify.com/processengine/core/processdefinition")
@XmlEnum
public enum MessageIntegrationDirection {

    @XmlEnumValue("implicit")
    IMPLICIT("implicit"),
    @XmlEnumValue("in")
    IN("in"),
    @XmlEnumValue("out")
    OUT("out");
    private final String value;

    MessageIntegrationDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageIntegrationDirection fromValue(String v) {
        for (MessageIntegrationDirection c: MessageIntegrationDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
