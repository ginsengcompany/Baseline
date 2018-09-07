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
@XmlType(name = "tErrorEventDefinition")
public class ErrorEventDefinition
    extends EventDefinition
{

    @XmlAttribute
    protected QName errorRef;


    public QName getErrorRef() {
        return errorRef;
    }


    public void setErrorRef(QName value) {
        this.errorRef = value;
    }

}
