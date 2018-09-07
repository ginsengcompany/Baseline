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
@XmlType(name = "tParticipant", propOrder = {
    "interfaceRef",
    "endPointRef",
    "participantMultiplicity"
})
public class Participant
    extends BaseElement
{

    protected List<QName> interfaceRef;
    protected List<QName> endPointRef;
    protected ParticipantMultiplicity participantMultiplicity;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected QName processRef;


    public List<QName> getInterfaceRef() {
        if (interfaceRef == null) {
            interfaceRef = new ArrayList<QName>();
        }
        return this.interfaceRef;
    }


    public List<QName> getEndPointRef() {
        if (endPointRef == null) {
            endPointRef = new ArrayList<QName>();
        }
        return this.endPointRef;
    }


    public ParticipantMultiplicity getParticipantMultiplicity() {
        return participantMultiplicity;
    }


    public void setParticipantMultiplicity(ParticipantMultiplicity value) {
        this.participantMultiplicity = value;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public QName getProcessRef() {
        return processRef;
    }


    public void setProcessRef(QName value) {
        this.processRef = value;
    }

}
