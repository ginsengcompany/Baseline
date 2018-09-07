/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputOutputBinding")
public class InputOutputBinding
    extends BaseElement
{

    @XmlAttribute(required = true)
    protected QName operationRef;
    @XmlAttribute(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object inputDataRef;
    @XmlAttribute(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object outputDataRef;


    public QName getOperationRef() {
        return operationRef;
    }


    public void setOperationRef(QName value) {
        this.operationRef = value;
    }


    public Object getInputDataRef() {
        return inputDataRef;
    }


    public void setInputDataRef(Object value) {
        this.inputDataRef = value;
    }


    public Object getOutputDataRef() {
        return outputDataRef;
    }


    public void setOutputDataRef(Object value) {
        this.outputDataRef = value;
    }

}
