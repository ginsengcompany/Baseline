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
@XmlType(name = "tCategory", propOrder = {
    "categoryValue"
})
public class Category
    extends RootElement
{

    protected List<CategoryValue> categoryValue;
    @XmlAttribute
    protected String name;


    public List<CategoryValue> getCategoryValue() {
        if (categoryValue == null) {
            categoryValue = new ArrayList<CategoryValue>();
        }
        return this.categoryValue;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

}
