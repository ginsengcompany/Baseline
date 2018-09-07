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
@XmlType(name = "tMultiInstanceLoopCharacteristics", propOrder = {
    "loopCardinality",
    "loopDataInputRef",
    "loopDataOutputRef",
    "inputDataItem",
    "outputDataItem",
    "complexBehaviorDefinition",
    "completionCondition"
})
public class MultiInstanceLoopCharacteristics
    extends LoopCharacteristics
{

    protected Expression loopCardinality;
    protected QName loopDataInputRef;
    protected QName loopDataOutputRef;
    protected DataInput inputDataItem;
    protected DataOutput outputDataItem;
    protected List<ComplexBehaviorDefinition> complexBehaviorDefinition;
    protected Expression completionCondition;
    @XmlAttribute
    protected Boolean isSequential;
    @XmlAttribute
    protected MultiInstanceFlowCondition behavior;
    @XmlAttribute
    protected QName oneBehaviorEventRef;
    @XmlAttribute
    protected QName noneBehaviorEventRef;


    public Expression getLoopCardinality() {
        return loopCardinality;
    }


    public void setLoopCardinality(Expression value) {
        this.loopCardinality = value;
    }


    public QName getLoopDataInputRef() {
        return loopDataInputRef;
    }


    public void setLoopDataInputRef(QName value) {
        this.loopDataInputRef = value;
    }


    public QName getLoopDataOutputRef() {
        return loopDataOutputRef;
    }


    public void setLoopDataOutputRef(QName value) {
        this.loopDataOutputRef = value;
    }


    public DataInput getInputDataItem() {
        return inputDataItem;
    }


    public void setInputDataItem(DataInput value) {
        this.inputDataItem = value;
    }


    public DataOutput getOutputDataItem() {
        return outputDataItem;
    }


    public void setOutputDataItem(DataOutput value) {
        this.outputDataItem = value;
    }


    public List<ComplexBehaviorDefinition> getComplexBehaviorDefinition() {
        if (complexBehaviorDefinition == null) {
            complexBehaviorDefinition = new ArrayList<ComplexBehaviorDefinition>();
        }
        return this.complexBehaviorDefinition;
    }


    public Expression getCompletionCondition() {
        return completionCondition;
    }


    public void setCompletionCondition(Expression value) {
        this.completionCondition = value;
    }


    public boolean isIsSequential() {
        if (isSequential == null) {
            return false;
        } else {
            return isSequential;
        }
    }


    public void setIsSequential(Boolean value) {
        this.isSequential = value;
    }


    public MultiInstanceFlowCondition getBehavior() {
        if (behavior == null) {
            return MultiInstanceFlowCondition.ALL;
        } else {
            return behavior;
        }
    }


    public void setBehavior(MultiInstanceFlowCondition value) {
        this.behavior = value;
    }


    public QName getOneBehaviorEventRef() {
        return oneBehaviorEventRef;
    }


    public void setOneBehaviorEventRef(QName value) {
        this.oneBehaviorEventRef = value;
    }


    public QName getNoneBehaviorEventRef() {
        return noneBehaviorEventRef;
    }


    public void setNoneBehaviorEventRef(QName value) {
        this.noneBehaviorEventRef = value;
    }

}
