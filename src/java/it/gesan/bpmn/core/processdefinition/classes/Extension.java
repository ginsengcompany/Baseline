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
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tExtension", propOrder = {
    "documentation"
})
public class Extension {

    protected List<Documentation> documentation;
    @XmlAttribute
    protected QName definition;
    @XmlAttribute
    protected Boolean mustUnderstand;


    public List<Documentation> getDocumentation() {
        if (documentation == null) {
            documentation = new ArrayList<Documentation>();
        }
        return this.documentation;
    }


    public QName getDefinition() {
        return definition;
    }


    public void setDefinition(QName value) {
        this.definition = value;
    }


    public boolean isMustUnderstand() {
        if (mustUnderstand == null) {
            return false;
        } else {
            return mustUnderstand;
        }
    }


    public void setMustUnderstand(Boolean value) {
        this.mustUnderstand = value;
    }

}
