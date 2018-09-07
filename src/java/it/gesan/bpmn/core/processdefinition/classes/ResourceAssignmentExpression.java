/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResourceAssignmentExpression", propOrder = {
    "expression"
})
public class ResourceAssignmentExpression
    extends BaseElement
{

    @XmlElementRef(name = "expression", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected JAXBElement<? extends Expression> expression;


    public JAXBElement<? extends Expression> getExpression() {
        return expression;
    }


    public void setExpression(JAXBElement<? extends Expression> value) {
        this.expression = ((JAXBElement<? extends Expression> ) value);
    }

}
