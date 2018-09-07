/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tParticipantMultiplicity")
public class ParticipantMultiplicity
    extends BaseElement
{

    @XmlAttribute
    protected Integer minimum;
    @XmlAttribute
    protected Integer maximum;


    public int getMinimum() {
        if (minimum == null) {
            return  0;
        } else {
            return minimum;
        }
    }


    public void setMinimum(Integer value) {
        this.minimum = value;
    }


    public int getMaximum() {
        if (maximum == null) {
            return  1;
        } else {
            return maximum;
        }
    }


    public void setMaximum(Integer value) {
        this.maximum = value;
    }

}
