/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCallableElement", propOrder = {
    "supportedInterfaceRef",
    "ioSpecification",
    "ioBinding"
})
@XmlSeeAlso({
    Process.class,
    GlobalTask.class
})
public class CallableElement
    extends RootElement
{

    protected List<QName> supportedInterfaceRef;
    protected InputOutputSpecification ioSpecification;
    protected List<InputOutputBinding> ioBinding;
    @XmlAttribute
    protected String name;


    public List<QName> getSupportedInterfaceRef() {
        if (supportedInterfaceRef == null) {
            supportedInterfaceRef = new ArrayList<QName>();
        }
        return this.supportedInterfaceRef;
    }


    public InputOutputSpecification getIoSpecification() {
        return ioSpecification;
    }


    public void setIoSpecification(InputOutputSpecification value) {
        this.ioSpecification = value;
    }


    public List<InputOutputBinding> getIoBinding() {
        if (ioBinding == null) {
            ioBinding = new ArrayList<InputOutputBinding>();
        }
        return this.ioBinding;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

}
