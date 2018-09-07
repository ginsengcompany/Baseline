/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCatchEvent", propOrder = {
    "dataOutput",
    "dataOutputAssociation",
    "outputSet",
    "eventDefinition",
    "eventDefinitionRef"
})
@XmlSeeAlso({
    StartEvent.class,
    IntermediateCatchEvent.class,
    BoundaryEvent.class
})
public abstract class CatchEvent
    extends Event
{

    protected List<DataOutput> dataOutput;
    protected List<DataOutputAssociation> dataOutputAssociation;
    protected OutputSet outputSet;
    @XmlElementRef(name = "eventDefinition", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends EventDefinition>> eventDefinition;
    protected List<QName> eventDefinitionRef;
    @XmlAttribute
    protected Boolean parallelMultiple;


    public List<DataOutput> getDataOutput() {
        if (dataOutput == null) {
            dataOutput = new ArrayList<DataOutput>();
        }
        return this.dataOutput;
    }


    public List<DataOutputAssociation> getDataOutputAssociation() {
        if (dataOutputAssociation == null) {
            dataOutputAssociation = new ArrayList<DataOutputAssociation>();
        }
        return this.dataOutputAssociation;
    }


    public OutputSet getOutputSet() {
        return outputSet;
    }


    public void setOutputSet(OutputSet value) {
        this.outputSet = value;
    }


    public List<JAXBElement<? extends EventDefinition>> getEventDefinition() {
        if (eventDefinition == null) {
            eventDefinition = new ArrayList<JAXBElement<? extends EventDefinition>>();
        }
        return this.eventDefinition;
    }


    public List<QName> getEventDefinitionRef() {
        if (eventDefinitionRef == null) {
            eventDefinitionRef = new ArrayList<QName>();
        }
        return this.eventDefinitionRef;
    }


    public boolean isParallelMultiple() {
        if (parallelMultiple == null) {
            return false;
        } else {
            return parallelMultiple;
        }
    }


    public void setParallelMultiple(Boolean value) {
        this.parallelMultiple = value;
    }

}
