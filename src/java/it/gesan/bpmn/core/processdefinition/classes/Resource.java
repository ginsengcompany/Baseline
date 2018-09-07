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
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResource", propOrder = {
    "resourceParameter"
})
public class Resource
    extends RootElement
{

    protected List<ResourceParameter> resourceParameter;
    @XmlAttribute(required = true)
    protected String name;


    public List<ResourceParameter> getResourceParameter() {
        if (resourceParameter == null) {
            resourceParameter = new ArrayList<ResourceParameter>();
        }
        return this.resourceParameter;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

}
