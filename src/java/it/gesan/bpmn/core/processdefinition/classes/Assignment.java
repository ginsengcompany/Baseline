/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAssignment", propOrder = {
    "from",
    "to"
})
public class Assignment
    extends BaseElement
{

    @XmlElement(required = true)
    protected Expression from;
    @XmlElement(required = true)
    protected Expression to;


    public Expression getFrom() {
        return from;
    }


    public void setFrom(Expression value) {
        this.from = value;
    }


    public Expression getTo() {
        return to;
    }


    public void setTo(Expression value) {
        this.to = value;
    }

}
