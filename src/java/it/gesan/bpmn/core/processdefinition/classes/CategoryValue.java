/**
 *
 * @author Antonio Biondillo
 */
package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCategoryValue")
public class CategoryValue
    extends BaseElement
{

    @XmlAttribute
    protected String value;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }

}
