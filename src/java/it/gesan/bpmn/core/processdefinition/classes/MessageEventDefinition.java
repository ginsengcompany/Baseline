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
@XmlType(name = "tMessageEventDefinition", propOrder = {
    "operationRef"
})
public class MessageEventDefinition
    extends EventDefinition
{

    protected QName operationRef;
    @XmlAttribute
    protected QName messageRef;


    public QName getOperationRef() {
        return operationRef;
    }


    public void setOperationRef(QName value) {
        this.operationRef = value;
    }


    public QName getMessageRef() {
        return messageRef;
    }


    public void setMessageRef(QName value) {
        this.messageRef = value;
    }

}
