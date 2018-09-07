/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCorrelationKey", propOrder = {
    "correlationPropertyRef"
})
public class CorrelationKey
    extends BaseElement
{

    protected List<QName> correlationPropertyRef;
    @XmlAttribute
    protected String name;


    public List<QName> getCorrelationPropertyRef() {
        if (correlationPropertyRef == null) {
            correlationPropertyRef = new ArrayList<QName>();
        }
        return this.correlationPropertyRef;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

}
