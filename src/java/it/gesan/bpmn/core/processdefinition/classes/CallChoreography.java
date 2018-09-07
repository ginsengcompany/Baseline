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
@XmlType(name = "tCallChoreography", propOrder = {
    "participantAssociation"
})
public class CallChoreography
    extends ChoreographyActivity
{

    protected List<ParticipantAssociation> participantAssociation;
    @XmlAttribute
    protected QName calledChoreographyRef;


    public List<ParticipantAssociation> getParticipantAssociation() {
        if (participantAssociation == null) {
            participantAssociation = new ArrayList<ParticipantAssociation>();
        }
        return this.participantAssociation;
    }


    public QName getCalledChoreographyRef() {
        return calledChoreographyRef;
    }


    public void setCalledChoreographyRef(QName value) {
        this.calledChoreographyRef = value;
    }

}
