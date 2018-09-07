/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tImport")
public class Import {

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String namespace;
    @XmlAttribute(required = true)
    protected String location;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String importType;


    public String getNamespace() {
        return namespace;
    }


    public void setNamespace(String value) {
        this.namespace = value;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String value) {
        this.location = value;
    }


    public String getImportType() {
        return importType;
    }


    public void setImportType(String value) {
        this.importType = value;
    }

}
