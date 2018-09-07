/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tItemKind")
@XmlEnum
public enum ItemKind {

    @XmlEnumValue("Information")
    INFORMATION("Information"),
    @XmlEnumValue("Physical")
    PHYSICAL("Physical");
    private final String value;

    ItemKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ItemKind fromValue(String v) {
        for (ItemKind c: ItemKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
