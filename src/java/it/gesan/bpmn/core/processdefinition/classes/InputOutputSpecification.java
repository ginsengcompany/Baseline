/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputOutputSpecification", propOrder = {
    "dataInput",
    "dataOutput",
    "inputSet",
    "outputSet"
})
public class InputOutputSpecification
    extends BaseElement
{

    protected List<DataInput> dataInput;
    protected List<DataOutput> dataOutput;
    @XmlElement(required = true)
    protected List<InputSet> inputSet;
    @XmlElement(required = true)
    protected List<OutputSet> outputSet;


    public List<DataInput> getDataInput() {
        if (dataInput == null) {
            dataInput = new ArrayList<DataInput>();
        }
        return this.dataInput;
    }


    public List<DataOutput> getDataOutput() {
        if (dataOutput == null) {
            dataOutput = new ArrayList<DataOutput>();
        }
        return this.dataOutput;
    }


    public List<InputSet> getInputSet() {
        if (inputSet == null) {
            inputSet = new ArrayList<InputSet>();
        }
        return this.inputSet;
    }


    public List<OutputSet> getOutputSet() {
        if (outputSet == null) {
            outputSet = new ArrayList<OutputSet>();
        }
        return this.outputSet;
    }

}
