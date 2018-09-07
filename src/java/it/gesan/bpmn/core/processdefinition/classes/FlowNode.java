/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFlowNode", propOrder = {
    "incoming",
    "outgoing"
})
@XmlSeeAlso({
    Event.class,
    ChoreographyActivity.class,
    Gateway.class,
    Activity.class
})
public abstract class FlowNode
    extends FlowElement
{

    protected List<QName> incoming;
    protected List<QName> outgoing;


    public List<QName> getIncoming() {
        if (incoming == null) {
            incoming = new ArrayList<QName>();
        }
        return this.incoming;
    }


    public List<QName> getOutgoing() {
        if (outgoing == null) {
            outgoing = new ArrayList<QName>();
        }
        return this.outgoing;
    }

}
