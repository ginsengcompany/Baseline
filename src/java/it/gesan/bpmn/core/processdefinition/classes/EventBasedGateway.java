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
@XmlType(name = "tEventBasedGateway")
public class EventBasedGateway
    extends Gateway
{

    @XmlAttribute
    protected Boolean instantiate;
    @XmlAttribute
    protected EventBasedGatewayType eventGatewayType;


    public boolean isInstantiate() {
        if (instantiate == null) {
            return false;
        } else {
            return instantiate;
        }
    }


    public void setInstantiate(Boolean value) {
        this.instantiate = value;
    }


    public EventBasedGatewayType getEventGatewayType() {
        if (eventGatewayType == null) {
            return EventBasedGatewayType.EXCLUSIVE;
        } else {
            return eventGatewayType;
        }
    }


    public void setEventGatewayType(EventBasedGatewayType value) {
        this.eventGatewayType = value;
    }

}
