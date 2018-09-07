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
@XmlType(name = "tCallActivity")
public class CallActivity
    extends Activity
{

    @XmlAttribute
    protected QName calledElement;


    public QName getCalledElement() {
        return calledElement;
    }


    public void setCalledElement(QName value) {
        this.calledElement = value;
    }

}
