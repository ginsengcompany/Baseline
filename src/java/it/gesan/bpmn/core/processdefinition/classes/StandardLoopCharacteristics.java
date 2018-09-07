/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tStandardLoopCharacteristics", propOrder = {
    "loopCondition"
})
public class StandardLoopCharacteristics
    extends LoopCharacteristics
{

    protected Expression loopCondition;
    @XmlAttribute
    protected Boolean testBefore;
    @XmlAttribute
    protected BigInteger loopMaximum;


    public Expression getLoopCondition() {
        return loopCondition;
    }


    public void setLoopCondition(Expression value) {
        this.loopCondition = value;
    }


    public boolean isTestBefore() {
        if (testBefore == null) {
            return false;
        } else {
            return testBefore;
        }
    }


    public void setTestBefore(Boolean value) {
        this.testBefore = value;
    }


    public BigInteger getLoopMaximum() {
        return loopMaximum;
    }


    public void setLoopMaximum(BigInteger value) {
        this.loopMaximum = value;
    }

}
