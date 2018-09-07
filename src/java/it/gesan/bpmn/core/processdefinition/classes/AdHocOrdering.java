/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "tAdHocOrdering")
@XmlEnum
public enum AdHocOrdering {

    @XmlEnumValue("Parallel")
    PARALLEL("Parallel"),
    @XmlEnumValue("Sequential")
    SEQUENTIAL("Sequential");
    private final String value;

    AdHocOrdering(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdHocOrdering fromValue(String v) {
        for (AdHocOrdering c: AdHocOrdering.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
