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
@XmlType(name = "tMessage")
public class Message
    extends RootElement
{

    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected QName itemRef;


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public QName getItemRef() {
        return itemRef;
    }


    public void setItemRef(QName value) {
        this.itemRef = value;
    }

}
