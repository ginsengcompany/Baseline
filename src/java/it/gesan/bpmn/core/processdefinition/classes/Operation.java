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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tOperation", propOrder = {
    "inMessageRef",
    "outMessageRef",
    "errorRef"
})
public class Operation
    extends BaseElement
{

    @XmlElement(required = true)
    protected QName inMessageRef;
    protected QName outMessageRef;
    protected List<QName> errorRef;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute
    protected QName implementationRef;


    public QName getInMessageRef() {
        return inMessageRef;
    }


    public void setInMessageRef(QName value) {
        this.inMessageRef = value;
    }


    public QName getOutMessageRef() {
        return outMessageRef;
    }


    public void setOutMessageRef(QName value) {
        this.outMessageRef = value;
    }


    public List<QName> getErrorRef() {
        if (errorRef == null) {
            errorRef = new ArrayList<QName>();
        }
        return this.errorRef;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public QName getImplementationRef() {
        return implementationRef;
    }


    public void setImplementationRef(QName value) {
        this.implementationRef = value;
    }

}
