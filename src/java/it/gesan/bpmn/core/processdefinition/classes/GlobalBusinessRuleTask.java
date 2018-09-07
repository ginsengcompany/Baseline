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
@XmlType(name = "tGlobalBusinessRuleTask")
public class GlobalBusinessRuleTask
    extends GlobalTask
{

    @XmlAttribute
    protected String implementation;


    public String getImplementation() {
        if (implementation == null) {
            return "##unspecified";
        } else {
            return implementation;
        }
    }


    public void setImplementation(String value) {
        this.implementation = value;
    }

}
