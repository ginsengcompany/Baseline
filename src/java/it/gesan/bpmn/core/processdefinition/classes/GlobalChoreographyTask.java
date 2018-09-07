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
@XmlType(name = "tGlobalChoreographyTask")
public class GlobalChoreographyTask
    extends Choreography
{

    @XmlAttribute
    protected QName initiatingParticipantRef;


    public QName getInitiatingParticipantRef() {
        return initiatingParticipantRef;
    }


    public void setInitiatingParticipantRef(QName value) {
        this.initiatingParticipantRef = value;
    }

}
