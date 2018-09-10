/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDefinitions", propOrder = {
    "_import",
    "extension",
    "rootElement",
    "relationship"
})
public class Definitions {

    @XmlElement(name = "import")
    protected List<Import> _import;
    protected List<Extension> extension;
    @XmlElementRef(name = "rootElement", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends RootElement>> rootElement;
    protected List<Relationship> relationship;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute
    protected String name;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String targetNamespace;
    @XmlAttribute
    @XmlSchemaType(name = "anyURI")
    protected String expressionLanguage;
    @XmlAttribute
    @XmlSchemaType(name = "anyURI")
    protected String typeLanguage;
    @XmlAttribute
    protected String exporter;
    @XmlAttribute
    protected String exporterVersion;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<Import> getImport() {
        if (_import == null) {
            _import = new ArrayList<Import>();
        }
        return this._import;
    }


    public List<Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<Extension>();
        }
        return this.extension;
    }


    public List<JAXBElement<? extends RootElement>> getRootElement() {
        if (rootElement == null) {
            rootElement = new ArrayList<JAXBElement<? extends RootElement>>();
        }
        return this.rootElement;
    }


    public List<Relationship> getRelationship() {
        if (relationship == null) {
            relationship = new ArrayList<Relationship>();
        }
        return this.relationship;
    }


    public String getId() {
        return id;
    }


    public void setId(String value) {
        this.id = value;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public String getTargetNamespace() {
        return targetNamespace;
    }


    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }


    public String getExpressionLanguage() {
        if (expressionLanguage == null) {
            return "http://www.w3.org/1999/XPath";
        } else {
            return expressionLanguage;
        }
    }


    public void setExpressionLanguage(String value) {
        this.expressionLanguage = value;
    }


    public String getTypeLanguage() {
        if (typeLanguage == null) {
            return "http://www.w3.org/2001/XMLSchema";
        } else {
            return typeLanguage;
        }
    }


    public void setTypeLanguage(String value) {
        this.typeLanguage = value;
    }


    public String getExporter() {
        return exporter;
    }


    public void setExporter(String value) {
        this.exporter = value;
    }


    public String getExporterVersion() {
        return exporterVersion;
    }


    public void setExporterVersion(String value) {
        this.exporterVersion = value;
    }


    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
