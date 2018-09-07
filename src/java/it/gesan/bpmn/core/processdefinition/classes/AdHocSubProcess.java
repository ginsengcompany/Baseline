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
@XmlType(name = "tAdHocSubProcess", propOrder = {
    "completionCondition"
})
public class AdHocSubProcess
    extends SubProcess
{

    protected Expression completionCondition;
    @XmlAttribute
    protected Boolean cancelRemainingInstances;
    @XmlAttribute
    protected AdHocOrdering ordering;


    public Expression getCompletionCondition() {
        return completionCondition;
    }


    public void setCompletionCondition(Expression value) {
        this.completionCondition = value;
    }


    public boolean isCancelRemainingInstances() {
        if (cancelRemainingInstances == null) {
            return true;
        } else {
            return cancelRemainingInstances;
        }
    }


    public void setCancelRemainingInstances(Boolean value) {
        this.cancelRemainingInstances = value;
    }


    public AdHocOrdering getOrdering() {
        return ordering;
    }


    public void setOrdering(AdHocOrdering value) {
        this.ordering = value;
    }

}
