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
@XmlType(name = "tSignalEventDefinition")
public class SignalEventDefinition
    extends EventDefinition
{

    @XmlAttribute
    protected QName signalRef;


    public QName getSignalRef() {
        return signalRef;
    }


    public void setSignalRef(QName value) {
        this.signalRef = value;
    }

}
