/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResourceParameter")
public class ResourceParameter
    extends BaseElement
{

    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected QName type;
    @XmlAttribute
    protected Boolean isRequired;


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public QName getType() {
        return type;
    }


    public void setType(QName value) {
        this.type = value;
    }


    public Boolean isIsRequired() {
        return isRequired;
    }


    public void setIsRequired(Boolean value) {
        this.isRequired = value;
    }

}
