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
@XmlType(name = "tMessageFlowAssociation")
public class MessageFlowAssociation
    extends BaseElement
{

    @XmlAttribute(required = true)
    protected QName innerMessageFlowRef;
    @XmlAttribute(required = true)
    protected QName outerMessageFlowRef;


    public QName getInnerMessageFlowRef() {
        return innerMessageFlowRef;
    }


    public void setInnerMessageFlowRef(QName value) {
        this.innerMessageFlowRef = value;
    }


    public QName getOuterMessageFlowRef() {
        return outerMessageFlowRef;
    }


    public void setOuterMessageFlowRef(QName value) {
        this.outerMessageFlowRef = value;
    }

}
