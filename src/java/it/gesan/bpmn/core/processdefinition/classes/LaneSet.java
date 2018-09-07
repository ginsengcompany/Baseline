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
@XmlType(name = "tLaneSet", propOrder = {
    "lane"
})
public class LaneSet
    extends BaseElement
{

    protected List<Lane> lane;
    @XmlAttribute
    protected String name;


    public List<Lane> getLane() {
        if (lane == null) {
            lane = new ArrayList<Lane>();
        }
        return this.lane;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

}
