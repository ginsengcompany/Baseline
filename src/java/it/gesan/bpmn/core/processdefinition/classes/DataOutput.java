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
@XmlType(name = "tDataOutput", propOrder = {
    "dataState"
})
public class DataOutput
    extends BaseElement
{

    protected DataState dataState;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected QName itemSubjectRef;
    @XmlAttribute
    protected Boolean isCollection;


    public DataState getDataState() {
        return dataState;
    }


    public void setDataState(DataState value) {
        this.dataState = value;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }


    public QName getItemSubjectRef() {
        return itemSubjectRef;
    }


    public void setItemSubjectRef(QName value) {
        this.itemSubjectRef = value;
    }


    public boolean isIsCollection() {
        if (isCollection == null) {
            return false;
        } else {
            return isCollection;
        }
    }


    public void setIsCollection(Boolean value) {
        this.isCollection = value;
    }

}
