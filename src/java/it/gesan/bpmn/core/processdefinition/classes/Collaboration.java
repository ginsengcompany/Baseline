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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCollaboration", propOrder = {
    "participant",
    "messageFlow",
    "artifact",
    "conversationNode",
    "conversationAssociation",
    "participantAssociation",
    "messageFlowAssociation",
    "correlationKey",
    "choreographyRef",
    "conversationLink"
})
@XmlSeeAlso({
    GlobalConversation.class,
    Choreography.class
})
public class Collaboration
    extends RootElement
{

    protected List<Participant> participant;
    protected List<MessageFlow> messageFlow;
    @XmlElementRef(name = "artifact", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends Artifact>> artifact;
    @XmlElementRef(name = "conversationNode", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class)
    protected List<JAXBElement<? extends ConversationNode>> conversationNode;
    protected List<ConversationAssociation> conversationAssociation;
    protected List<ParticipantAssociation> participantAssociation;
    protected List<MessageFlowAssociation> messageFlowAssociation;
    protected List<CorrelationKey> correlationKey;
    protected List<QName> choreographyRef;
    protected List<ConversationLink> conversationLink;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected Boolean isClosed;


    public List<Participant> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<Participant>();
        }
        return this.participant;
    }


    public List<MessageFlow> getMessageFlow() {
        if (messageFlow == null) {
            messageFlow = new ArrayList<MessageFlow>();
        }
        return this.messageFlow;
    }


    public List<JAXBElement<? extends Artifact>> getArtifact() {
        if (artifact == null) {
            artifact = new ArrayList<JAXBElement<? extends Artifact>>();
        }
        return this.artifact;
    }


    public List<JAXBElement<? extends ConversationNode>> getConversationNode() {
        if (conversationNode == null) {
            conversationNode = new ArrayList<JAXBElement<? extends ConversationNode>>();
        }
        return this.conversationNode;
    }


    public List<ConversationAssociation> getConversationAssociation() {
        if (conversationAssociation == null) {
            conversationAssociation = new ArrayList<ConversationAssociation>();
        }
        return this.conversationAssociation;
    }


    public List<ParticipantAssociation> getParticipantAssociation() {
        if (participantAssociation == null) {
            participantAssociation = new ArrayList<ParticipantAssociation>();
        }
        return this.participantAssociation;
    }


    public List<MessageFlowAssociation> getMessageFlowAssociation() {
        if (messageFlowAssociation == null) {
            messageFlowAssociation = new ArrayList<MessageFlowAssociation>();
        }
        return this.messageFlowAssociation;
    }


    public List<CorrelationKey> getCorrelationKey() {
        if (correlationKey == null) {
            correlationKey = new ArrayList<CorrelationKey>();
        }
        return this.correlationKey;
    }


    public List<QName> getChoreographyRef() {
        if (choreographyRef == null) {
            choreographyRef = new ArrayList<QName>();
        }
        return this.choreographyRef;
    }


    public List<ConversationLink> getConversationLink() {
        if (conversationLink == null) {
            conversationLink = new ArrayList<ConversationLink>();
        }
        return this.conversationLink;
    }


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
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

}
