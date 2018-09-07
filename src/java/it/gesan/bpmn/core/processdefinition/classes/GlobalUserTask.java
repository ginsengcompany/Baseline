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
@XmlType(name = "tGlobalUserTask", propOrder = {
    "rendering"
})
public class GlobalUserTask
    extends GlobalTask
{

    protected List<Rendering> rendering;
    @XmlAttribute
    protected String implementation;


    public List<Rendering> getRendering() {
        if (rendering == null) {
            rendering = new ArrayList<Rendering>();
        }
        return this.rendering;
    }


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
