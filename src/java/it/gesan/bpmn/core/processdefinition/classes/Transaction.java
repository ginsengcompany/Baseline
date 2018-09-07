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
@XmlType(name = "tTransaction")
public class Transaction
    extends SubProcess
{

    @XmlAttribute
    protected String method;


    public String getMethod() {
        if (method == null) {
            return "##Compensate";
        } else {
            return method;
        }
    }


    public void setMethod(String value) {
        this.method = value;
    }

}
