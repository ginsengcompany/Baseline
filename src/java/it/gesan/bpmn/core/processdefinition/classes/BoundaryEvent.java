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
@XmlType(name = "tBoundaryEvent")
public class BoundaryEvent
    extends CatchEvent
{

    @XmlAttribute
    protected Boolean cancelActivity;
    @XmlAttribute(required = true)
    protected QName attachedToRef;


    public boolean isCancelActivity() {
        if (cancelActivity == null) {
            return true;
        } else {
            return cancelActivity;
        }
    }


    public void setCancelActivity(Boolean value) {
        this.cancelActivity = value;
    }


    public QName getAttachedToRef() {
        return attachedToRef;
    }


    public void setAttachedToRef(QName value) {
        this.attachedToRef = value;
    }

}
