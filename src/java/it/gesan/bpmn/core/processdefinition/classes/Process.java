/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tProcess", propOrder = {
    "auditing",
    "monitoring",
    "property",
    "laneSet",
    "flowElement",
    "artifact",
    "resourceRole",
    "correlationSubscription",
    "supports"
})
public class Process
    extends CallableElement
{

    protected Auditing auditing;
    protected Monitoring monitoring;
    protected List<Property> property;
    protected List<LaneSet> laneSet;
    @XmlElementRef(name = "flowElement", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends FlowElement>> flowElement;
    @XmlElementRef(name = "artifact", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends Artifact>> artifact;
    @XmlElementRef(name = "resourceRole", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends ResourceRole>> resourceRole;
    protected List<CorrelationSubscription> correlationSubscription;
    protected List<QName> supports;
    @XmlAttribute
    protected ProcessType processType;
    @XmlAttribute
    protected Boolean isClosed;
    @XmlAttribute
    protected Boolean isExecutable;
    @XmlAttribute
    protected QName definitionalCollaborationRef;


    public Auditing getAuditing() {
        return auditing;
    }


    public void setAuditing(Auditing value) {
        this.auditing = value;
    }


    public Monitoring getMonitoring() {
        return monitoring;
    }


    public void setMonitoring(Monitoring value) {
        this.monitoring = value;
    }


    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }


    public List<LaneSet> getLaneSet() {
        if (laneSet == null) {
            laneSet = new ArrayList<LaneSet>();
        }
        return this.laneSet;
    }


    public List<JAXBElement<? extends FlowElement>> getFlowElement() {
        if (flowElement == null) {
            flowElement = new ArrayList<JAXBElement<? extends FlowElement>>();
        }
        return this.flowElement;
    }


    public List<JAXBElement<? extends Artifact>> getArtifact() {
        if (artifact == null) {
            artifact = new ArrayList<JAXBElement<? extends Artifact>>();
        }
        return this.artifact;
    }


    public List<JAXBElement<? extends ResourceRole>> getResourceRole() {
        if (resourceRole == null) {
            resourceRole = new ArrayList<JAXBElement<? extends ResourceRole>>();
        }
        return this.resourceRole;
    }


    public List<CorrelationSubscription> getCorrelationSubscription() {
        if (correlationSubscription == null) {
            correlationSubscription = new ArrayList<CorrelationSubscription>();
        }
        return this.correlationSubscription;
    }


    public List<QName> getSupports() {
        if (supports == null) {
            supports = new ArrayList<QName>();
        }
        return this.supports;
    }


    public ProcessType getProcessType() {
        if (processType == null) {
            return ProcessType.NONE;
        } else {
            return processType;
        }
    }


    public void setProcessType(ProcessType value) {
        this.processType = value;
    }


    public boolean isIsClosed() {
        if (isClosed == null) {
            return false;
        } else {
            return isClosed;
        }
    }


    public void setIsClosed(Boolean value) {
        this.isClosed = value;
    }


    public Boolean isIsExecutable() {
        return isExecutable;
    }


    public void setIsExecutable(Boolean value) {
        this.isExecutable = value;
    }


    public QName getDefinitionalCollaborationRef() {
        return definitionalCollaborationRef;
    }


    public void setDefinitionalCollaborationRef(QName value) {
        this.definitionalCollaborationRef = value;
    }

}
