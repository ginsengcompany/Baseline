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
@XmlType(name = "tStartEvent")
public class StartEvent
    extends CatchEvent
{

    @XmlAttribute
    protected Boolean isInterrupting;


    public boolean isIsInterrupting() {
        if (isInterrupting == null) {
            return true;
        } else {
            return isInterrupting;
        }
    }


    public void setIsInterrupting(Boolean value) {
        this.isInterrupting = value;
    }

}
