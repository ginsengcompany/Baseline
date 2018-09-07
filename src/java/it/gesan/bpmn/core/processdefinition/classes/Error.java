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
@XmlType(name = "tError")
public class Error
    extends RootElement
{

    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected String errorCode;
    @XmlAttribute
    protected QName structureRef;


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public String getErrorCode() {
        return errorCode;
    }


    public void setErrorCode(String value) {
        this.errorCode = value;
    }


    public QName getStructureRef() {
        return structureRef;
    }


    public void setStructureRef(QName value) {
        this.structureRef = value;
    }

}
