/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;

import org.w3c.dom.Element;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tScript", propOrder = {
    "content"
})
public class Script {

    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> content;


    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
