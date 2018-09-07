/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tActivity", propOrder = {
    "ioSpecification",
    "property",
    "dataInputAssociation",
    "dataOutputAssociation",
    "resourceRole",
    "loopCharacteristics"
})
@XmlSeeAlso({
    SubProcess.class,
    Task.class,
    CallActivity.class
})
public abstract class Activity
    extends FlowNode
{

    protected InputOutputSpecification ioSpecification;
    protected List<Property> property;
    protected List<DataInputAssociation> dataInputAssociation;
    protected List<DataOutputAssociation> dataOutputAssociation;
    @XmlElementRef(name = "resourceRole", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends ResourceRole>> resourceRole;
    @XmlElementRef(name = "loopCharacteristics", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected JAXBElement<? extends LoopCharacteristics> loopCharacteristics;
    @XmlAttribute
    protected Boolean isForCompensation;
    @XmlAttribute
    protected BigInteger startQuantity;
    @XmlAttribute
    protected BigInteger completionQuantity;
    @XmlAttribute(name = "default")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object _default;


    public InputOutputSpecification getIoSpecification() {
        return ioSpecification;
    }


    public void setIoSpecification(InputOutputSpecification value) {
        this.ioSpecification = value;
    }


    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }


    public List<DataInputAssociation> getDataInputAssociation() {
        if (dataInputAssociation == null) {
            dataInputAssociation = new ArrayList<DataInputAssociation>();
        }
        return this.dataInputAssociation;
    }


    public List<DataOutputAssociation> getDataOutputAssociation() {
        if (dataOutputAssociation == null) {
            dataOutputAssociation = new ArrayList<DataOutputAssociation>();
        }
        return this.dataOutputAssociation;
    }


    public List<JAXBElement<? extends ResourceRole>> getResourceRole() {
        if (resourceRole == null) {
            resourceRole = new ArrayList<JAXBElement<? extends ResourceRole>>();
        }
        return this.resourceRole;
    }


    public JAXBElement<? extends LoopCharacteristics> getLoopCharacteristics() {
        return loopCharacteristics;
    }


    public void setLoopCharacteristics(JAXBElement<? extends LoopCharacteristics> value) {
        this.loopCharacteristics = ((JAXBElement<? extends LoopCharacteristics> ) value);
    }


    public boolean isIsForCompensation() {
        if (isForCompensation == null) {
            return false;
        } else {
            return isForCompensation;
        }
    }


    public void setIsForCompensation(Boolean value) {
        this.isForCompensation = value;
    }


    public BigInteger getStartQuantity() {
        if (startQuantity == null) {
            return new BigInteger("1");
        } else {
            return startQuantity;
        }
    }


    public void setStartQuantity(BigInteger value) {
        this.startQuantity = value;
    }


    public BigInteger getCompletionQuantity() {
        if (completionQuantity == null) {
            return new BigInteger("1");
        } else {
            return completionQuantity;
        }
    }


    public void setCompletionQuantity(BigInteger value) {
        this.completionQuantity = value;
    }


    public Object getDefault() {
        return _default;
    }


    public void setDefault(Object value) {
        this._default = value;
    }

}
