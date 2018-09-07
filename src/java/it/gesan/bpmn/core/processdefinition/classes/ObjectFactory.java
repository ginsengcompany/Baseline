/**
 *
 * @author Antonio Biondillo
 */

package it.gesan.bpmn.core.processdefinition.classes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



@XmlRegistry
public class ObjectFactory {

    private final static QName _ExtensionElements_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "extensionElements");
    private final static QName _HumanPerformer_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "humanPerformer");
    private final static QName _Collaboration_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "collaboration");
    private final static QName _ParticipantMultiplicity_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "participantMultiplicity");
    private final static QName _ScriptTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "scriptTask");
    private final static QName _SequenceFlow_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "sequenceFlow");
    private final static QName _GlobalBusinessRuleTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "globalBusinessRuleTask");
    private final static QName _DataAssociation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataAssociation");
    private final static QName _InputSet_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "inputSet");
    private final static QName _DataInputAssociation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataInputAssociation");
    private final static QName _IntermediateThrowEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "intermediateThrowEvent");
    private final static QName _ErrorEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "errorEventDefinition");
    private final static QName _ReceiveTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "receiveTask");
    private final static QName _Conversation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "conversation");
    private final static QName _ImplicitThrowEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "implicitThrowEvent");
    private final static QName _InclusiveGateway_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "inclusiveGateway");
    private final static QName _IntermediateCatchEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "intermediateCatchEvent");
    private final static QName _OutputSet_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "outputSet");
    private final static QName _LoopCharacteristics_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "loopCharacteristics");
    private final static QName _Relationship_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "relationship");
    private final static QName _Process_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "process");
    private final static QName _Extension_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "extension");
    private final static QName _ConditionalEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "conditionalEventDefinition");
    private final static QName _Assignment_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "assignment");
    private final static QName _Artifact_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "artifact");
    private final static QName _FlowNode_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "flowNode");
    private final static QName _EndPoint_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "endPoint");
    private final static QName _MessageFlow_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "messageFlow");
    private final static QName _SubProcess_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "subProcess");
    private final static QName _EndEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "endEvent");
    private final static QName _Documentation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "documentation");
    private final static QName _BaseElement_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "baseElement");
    private final static QName _TerminateEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "terminateEventDefinition");
    private final static QName _EventBasedGateway_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "eventBasedGateway");
    private final static QName _GlobalScriptTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "globalScriptTask");
    private final static QName _TimerEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "timerEventDefinition");
    private final static QName _ComplexGateway_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "complexGateway");
    private final static QName _ManualTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "manualTask");
    private final static QName _CallableElement_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "callableElement");
    private final static QName _CancelEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "cancelEventDefinition");
    private final static QName _ServiceTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "serviceTask");
    private final static QName _Operation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "operation");
    private final static QName _SubChoreography_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "subChoreography");
    private final static QName _CorrelationSubscription_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "correlationSubscription");
    private final static QName _ChoreographyActivity_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "choreographyActivity");
    private final static QName _Event_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "event");
    private final static QName _GlobalConversation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "globalConversation");
    private final static QName _Import_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "import");
    private final static QName _ResourceAssignmentExpression_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "resourceAssignmentExpression");
    private final static QName _EventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "eventDefinition");
    private final static QName _Monitoring_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "monitoring");
    private final static QName _ThrowEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "throwEvent");
    private final static QName _ItemDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "itemDefinition");
    private final static QName _AdHocSubProcess_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "adHocSubProcess");
    private final static QName _GlobalUserTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "globalUserTask");
    private final static QName _Category_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "category");
    private final static QName _StartEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "startEvent");
    private final static QName _Participant_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "participant");
    private final static QName _Performer_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "performer");
    private final static QName _FormalExpression_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "formalExpression");
    private final static QName _MessageEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "messageEventDefinition");
    private final static QName _CatchEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "catchEvent");
    private final static QName _DataOutputAssociation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataOutputAssociation");
    private final static QName _DataObjectReference_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataObjectReference");
    private final static QName _BoundaryEvent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "boundaryEvent");
    private final static QName _ParticipantAssociation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "participantAssociation");
    private final static QName _SendTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "sendTask");
    private final static QName _CategoryValue_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "categoryValue");
    private final static QName _Choreography_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "choreography");
    private final static QName _GlobalChoreographyTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "globalChoreographyTask");
    private final static QName _CallChoreography_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "callChoreography");
    private final static QName _MultiInstanceLoopCharacteristics_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "multiInstanceLoopCharacteristics");
    private final static QName _PotentialOwner_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "potentialOwner");
    private final static QName _CorrelationPropertyBinding_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "correlationPropertyBinding");
    private final static QName _Signal_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "signal");
    private final static QName _UserTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "userTask");
    private final static QName _ParallelGateway_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "parallelGateway");
    private final static QName _Lane_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "lane");
    private final static QName _SubConversation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "subConversation");
    private final static QName _BaseElementWithMixedContent_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "baseElementWithMixedContent");
    private final static QName _DataStore_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataStore");
    private final static QName _SignalEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "signalEventDefinition");
    private final static QName _RootElement_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "rootElement");
    private final static QName _DataState_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataState");
    private final static QName _CorrelationPropertyRetrievalExpression_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "correlationPropertyRetrievalExpression");
    private final static QName _IoSpecification_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "ioSpecification");
    private final static QName _ConversationAssociation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "conversationAssociation");
    private final static QName _LaneSet_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "laneSet");
    private final static QName _Activity_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "activity");
    private final static QName _GlobalTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "globalTask");
    private final static QName _Error_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "error");
    private final static QName _Task_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "task");
    private final static QName _Resource_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "resource");
    private final static QName _Interface_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "interface");
    private final static QName _CorrelationKey_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "correlationKey");
    private final static QName _Rendering_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "rendering");
    private final static QName _ResourceParameterBinding_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "resourceParameterBinding");
    private final static QName _ExclusiveGateway_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "exclusiveGateway");
    private final static QName _CorrelationProperty_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "correlationProperty");
    private final static QName _Message_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "message");
    private final static QName _DataStoreReference_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataStoreReference");
    private final static QName _GlobalManualTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "globalManualTask");
    private final static QName _Escalation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "escalation");
    private final static QName _CallActivity_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "callActivity");
    private final static QName _TextAnnotation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "textAnnotation");
    private final static QName _Group_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "group");
    private final static QName _Auditing_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "auditing");
    private final static QName _DataOutput_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataOutput");
    private final static QName _Expression_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "expression");
    private final static QName _Transaction_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "transaction");
    private final static QName _ChoreographyTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "choreographyTask");
    private final static QName _Gateway_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "gateway");
    private final static QName _ResourceRole_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "resourceRole");
    private final static QName _PartnerEntity_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "partnerEntity");
    private final static QName _PartnerRole_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "partnerRole");
    private final static QName _BusinessRuleTask_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "businessRuleTask");
    private final static QName _IoBinding_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "ioBinding");
    private final static QName _FlowElement_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "flowElement");
    private final static QName _DataObject_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataObject");
    private final static QName _LinkEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "linkEventDefinition");
    private final static QName _ResourceParameter_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "resourceParameter");
    private final static QName _Text_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "text");
    private final static QName _Association_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "association");
    private final static QName _CallConversation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "callConversation");
    private final static QName _EscalationEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "escalationEventDefinition");
    private final static QName _Definitions_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "definitions");
    private final static QName _Property_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "property");
    private final static QName _Script_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "script");
    private final static QName _DataInput_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataInput");
    private final static QName _ConversationNode_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "conversationNode");
    private final static QName _CompensateEventDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "compensateEventDefinition");
    private final static QName _ComplexBehaviorDefinition_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "complexBehaviorDefinition");
    private final static QName _ConversationLink_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "conversationLink");
    private final static QName _MessageFlowAssociation_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "messageFlowAssociation");
    private final static QName _StandardLoopCharacteristics_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "standardLoopCharacteristics");
    private final static QName _TDataAssociationSourceRef_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "sourceRef");
    private final static QName _TOutputSetDataOutputRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataOutputRefs");
    private final static QName _TOutputSetOptionalOutputRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "optionalOutputRefs");
    private final static QName _TOutputSetWhileExecutingOutputRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "whileExecutingOutputRefs");
    private final static QName _TOutputSetInputSetRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "inputSetRefs");
    private final static QName _TInputSetWhileExecutingInputRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "whileExecutingInputRefs");
    private final static QName _TInputSetOutputSetRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "outputSetRefs");
    private final static QName _TInputSetOptionalInputRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "optionalInputRefs");
    private final static QName _TInputSetDataInputRefs_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "dataInputRefs");
    private final static QName _TLaneFlowNodeRef_QNAME = new QName("http://www.omg.org/spec/BPMN/20100524/MODEL", "flowNodeRef");


    public ObjectFactory() {
    }


    public EscalationEventDefinition createTEscalationEventDefinition() {
        return new EscalationEventDefinition();
    }


    public DataOutput createTDataOutput() {
        return new DataOutput();
    }


    public DataState createTDataState() {
        return new DataState();
    }


    public ResourceRole createTResourceRole() {
        return new ResourceRole();
    }


    public ComplexBehaviorDefinition createTComplexBehaviorDefinition() {
        return new ComplexBehaviorDefinition();
    }


    public InputOutputSpecification createTInputOutputSpecification() {
        return new InputOutputSpecification();
    }


    public DataInputAssociation createTDataInputAssociation() {
        return new DataInputAssociation();
    }


    public EndPoint createTEndPoint() {
        return new EndPoint();
    }


    public Definitions createTDefinitions() {
        return new Definitions();
    }


    public Documentation createTDocumentation() {
        return new Documentation();
    }


    public FormalExpression createTFormalExpression() {
        return new FormalExpression();
    }


    public Resource createTResource() {
        return new Resource();
    }


    public ConditionalEventDefinition createTConditionalEventDefinition() {
        return new ConditionalEventDefinition();
    }


    public StandardLoopCharacteristics createTStandardLoopCharacteristics() {
        return new StandardLoopCharacteristics();
    }


    public Gateway createTGateway() {
        return new Gateway();
    }


    public CallActivity createTCallActivity() {
        return new CallActivity();
    }


    public TextAnnotation createTTextAnnotation() {
        return new TextAnnotation();
    }


    public SequenceFlow createTSequenceFlow() {
        return new SequenceFlow();
    }


    public ExclusiveGateway createTExclusiveGateway() {
        return new ExclusiveGateway();
    }


    public MessageFlowAssociation createTMessageFlowAssociation() {
        return new MessageFlowAssociation();
    }


    public GlobalUserTask createTGlobalUserTask() {
        return new GlobalUserTask();
    }


    public Interface createTInterface() {
        return new Interface();
    }


    public ErrorEventDefinition createTErrorEventDefinition() {
        return new ErrorEventDefinition();
    }


    public Property createTProperty() {
        return new Property();
    }


    public Category createTCategory() {
        return new Category();
    }


    public LaneSet createTLaneSet() {
        return new LaneSet();
    }


    public TerminateEventDefinition createTTerminateEventDefinition() {
        return new TerminateEventDefinition();
    }


    public CallableElement createTCallableElement() {
        return new CallableElement();
    }


    public MessageEventDefinition createTMessageEventDefinition() {
        return new MessageEventDefinition();
    }


    public PotentialOwner createTPotentialOwner() {
        return new PotentialOwner();
    }


    public Expression createTExpression() {
        return new Expression();
    }


    public Script createTScript() {
        return new Script();
    }


    public Auditing createTAuditing() {
        return new Auditing();
    }


    public ResourceParameter createTResourceParameter() {
        return new ResourceParameter();
    }


    public Relationship createTRelationship() {
        return new Relationship();
    }


    public InputOutputBinding createTInputOutputBinding() {
        return new InputOutputBinding();
    }


    public CallConversation createTCallConversation() {
        return new CallConversation();
    }


    public BoundaryEvent createTBoundaryEvent() {
        return new BoundaryEvent();
    }


    public SubChoreography createTSubChoreography() {
        return new SubChoreography();
    }


    public ConversationLink createTConversationLink() {
        return new ConversationLink();
    }


    public Group createTGroup() {
        return new Group();
    }


    public Process createTProcess() {
        return new Process();
    }


    public LinkEventDefinition createTLinkEventDefinition() {
        return new LinkEventDefinition();
    }


    public Assignment createTAssignment() {
        return new Assignment();
    }


    public EndEvent createTEndEvent() {
        return new EndEvent();
    }


    public Lane createTLane() {
        return new Lane();
    }


    public Association createTAssociation() {
        return new Association();
    }


    public ParticipantAssociation createTParticipantAssociation() {
        return new ParticipantAssociation();
    }


    public DataObject createTDataObject() {
        return new DataObject();
    }


    public CompensateEventDefinition createTCompensateEventDefinition() {
        return new CompensateEventDefinition();
    }


    public Rendering createTRendering() {
        return new Rendering();
    }


    public DataAssociation createTDataAssociation() {
        return new DataAssociation();
    }


    public DataStore createTDataStore() {
        return new DataStore();
    }


    public SignalEventDefinition createTSignalEventDefinition() {
        return new SignalEventDefinition();
    }


    public IntermediateCatchEvent createTIntermediateCatchEvent() {
        return new IntermediateCatchEvent();
    }


    public CancelEventDefinition createTCancelEventDefinition() {
        return new CancelEventDefinition();
    }


    public BusinessRuleTask createTBusinessRuleTask() {
        return new BusinessRuleTask();
    }


    public TimerEventDefinition createTTimerEventDefinition() {
        return new TimerEventDefinition();
    }


    public GlobalConversation createTGlobalConversation() {
        return new GlobalConversation();
    }


    public PartnerRole createTPartnerRole() {
        return new PartnerRole();
    }


    public Escalation createTEscalation() {
        return new Escalation();
    }


    public Performer createTPerformer() {
        return new Performer();
    }


    public Task createTTask() {
        return new Task();
    }


    public Participant createTParticipant() {
        return new Participant();
    }


    public HumanPerformer createTHumanPerformer() {
        return new HumanPerformer();
    }


    public CorrelationKey createTCorrelationKey() {
        return new CorrelationKey();
    }


    public GlobalChoreographyTask createTGlobalChoreographyTask() {
        return new GlobalChoreographyTask();
    }


    public ReceiveTask createTReceiveTask() {
        return new ReceiveTask();
    }


    public GlobalManualTask createTGlobalManualTask() {
        return new GlobalManualTask();
    }


    public CorrelationSubscription createTCorrelationSubscription() {
        return new CorrelationSubscription();
    }


    public Signal createTSignal() {
        return new Signal();
    }


    public SendTask createTSendTask() {
        return new SendTask();
    }


    public Transaction createTTransaction() {
        return new Transaction();
    }


    public Import createTImport() {
        return new Import();
    }


    public EventBasedGateway createTEventBasedGateway() {
        return new EventBasedGateway();
    }


    public AdHocSubProcess createTAdHocSubProcess() {
        return new AdHocSubProcess();
    }


    public CorrelationPropertyBinding createTCorrelationPropertyBinding() {
        return new CorrelationPropertyBinding();
    }


    public ExtensionElements createTExtensionElements() {
        return new ExtensionElements();
    }


    public PartnerEntity createTPartnerEntity() {
        return new PartnerEntity();
    }


    public Conversation createTConversation() {
        return new Conversation();
    }


    public ManualTask createTManualTask() {
        return new ManualTask();
    }


    public Message createTMessage() {
        return new Message();
    }


    public Collaboration createTCollaboration() {
        return new Collaboration();
    }


    public GlobalTask createTGlobalTask() {
        return new GlobalTask();
    }


    public Monitoring createTMonitoring() {
        return new Monitoring();
    }


    public DataObjectReference createTDataObjectReference() {
        return new DataObjectReference();
    }


    public SubProcess createTSubProcess() {
        return new SubProcess();
    }


    public CorrelationPropertyRetrievalExpression createTCorrelationPropertyRetrievalExpression() {
        return new CorrelationPropertyRetrievalExpression();
    }


    public InclusiveGateway createTInclusiveGateway() {
        return new InclusiveGateway();
    }


    public CategoryValue createTCategoryValue() {
        return new CategoryValue();
    }


    public StartEvent createTStartEvent() {
        return new StartEvent();
    }


    public CallChoreography createTCallChoreography() {
        return new CallChoreography();
    }


    public ResourceParameterBinding createTResourceParameterBinding() {
        return new ResourceParameterBinding();
    }


    public CorrelationProperty createTCorrelationProperty() {
        return new CorrelationProperty();
    }


    public Choreography createTChoreography() {
        return new Choreography();
    }


    public MessageFlow createTMessageFlow() {
        return new MessageFlow();
    }


    public GlobalBusinessRuleTask createTGlobalBusinessRuleTask() {
        return new GlobalBusinessRuleTask();
    }


    public OutputSet createTOutputSet() {
        return new OutputSet();
    }


    public InputSet createTInputSet() {
        return new InputSet();
    }


    public ComplexGateway createTComplexGateway() {
        return new ComplexGateway();
    }


    public ServiceTask createTServiceTask() {
        return new ServiceTask();
    }


    public Operation createTOperation() {
        return new Operation();
    }


    public Extension createTExtension() {
        return new Extension();
    }


    public ConversationAssociation createTConversationAssociation() {
        return new ConversationAssociation();
    }


    public IntermediateThrowEvent createTIntermediateThrowEvent() {
        return new IntermediateThrowEvent();
    }


    public SubConversation createTSubConversation() {
        return new SubConversation();
    }


    public Error createTError() {
        return new Error();
    }


    public ChoreographyTask createTChoreographyTask() {
        return new ChoreographyTask();
    }


    public DataOutputAssociation createTDataOutputAssociation() {
        return new DataOutputAssociation();
    }


    public Text createTText() {
        return new Text();
    }


    public MultiInstanceLoopCharacteristics createTMultiInstanceLoopCharacteristics() {
        return new MultiInstanceLoopCharacteristics();
    }


    public ParallelGateway createTParallelGateway() {
        return new ParallelGateway();
    }


    public ItemDefinition createTItemDefinition() {
        return new ItemDefinition();
    }


    public ResourceAssignmentExpression createTResourceAssignmentExpression() {
        return new ResourceAssignmentExpression();
    }


    public DataStoreReference createTDataStoreReference() {
        return new DataStoreReference();
    }


    public UserTask createTUserTask() {
        return new UserTask();
    }


    public ImplicitThrowEvent createTImplicitThrowEvent() {
        return new ImplicitThrowEvent();
    }


    public DataInput createTDataInput() {
        return new DataInput();
    }


    public GlobalScriptTask createTGlobalScriptTask() {
        return new GlobalScriptTask();
    }


    public ScriptTask createTScriptTask() {
        return new ScriptTask();
    }


    public ParticipantMultiplicity createTParticipantMultiplicity() {
        return new ParticipantMultiplicity();
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "extensionElements")
    public JAXBElement<ExtensionElements> createExtensionElements(ExtensionElements value) {
        return new JAXBElement<ExtensionElements>(_ExtensionElements_QNAME, ExtensionElements.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "humanPerformer", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "performer")
    public JAXBElement<HumanPerformer> createHumanPerformer(HumanPerformer value) {
        return new JAXBElement<HumanPerformer>(_HumanPerformer_QNAME, HumanPerformer.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "collaboration", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Collaboration> createCollaboration(Collaboration value) {
        return new JAXBElement<Collaboration>(_Collaboration_QNAME, Collaboration.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "participantMultiplicity")
    public JAXBElement<ParticipantMultiplicity> createParticipantMultiplicity(ParticipantMultiplicity value) {
        return new JAXBElement<ParticipantMultiplicity>(_ParticipantMultiplicity_QNAME, ParticipantMultiplicity.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "scriptTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ScriptTask> createScriptTask(ScriptTask value) {
        return new JAXBElement<ScriptTask>(_ScriptTask_QNAME, ScriptTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "sequenceFlow", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<SequenceFlow> createSequenceFlow(SequenceFlow value) {
        return new JAXBElement<SequenceFlow>(_SequenceFlow_QNAME, SequenceFlow.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "globalBusinessRuleTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<GlobalBusinessRuleTask> createGlobalBusinessRuleTask(GlobalBusinessRuleTask value) {
        return new JAXBElement<GlobalBusinessRuleTask>(_GlobalBusinessRuleTask_QNAME, GlobalBusinessRuleTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataAssociation")
    public JAXBElement<DataAssociation> createDataAssociation(DataAssociation value) {
        return new JAXBElement<DataAssociation>(_DataAssociation_QNAME, DataAssociation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "inputSet")
    public JAXBElement<InputSet> createInputSet(InputSet value) {
        return new JAXBElement<InputSet>(_InputSet_QNAME, InputSet.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataInputAssociation")
    public JAXBElement<DataInputAssociation> createDataInputAssociation(DataInputAssociation value) {
        return new JAXBElement<DataInputAssociation>(_DataInputAssociation_QNAME, DataInputAssociation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "intermediateThrowEvent", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<IntermediateThrowEvent> createIntermediateThrowEvent(IntermediateThrowEvent value) {
        return new JAXBElement<IntermediateThrowEvent>(_IntermediateThrowEvent_QNAME, IntermediateThrowEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "errorEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<ErrorEventDefinition> createErrorEventDefinition(ErrorEventDefinition value) {
        return new JAXBElement<ErrorEventDefinition>(_ErrorEventDefinition_QNAME, ErrorEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "receiveTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ReceiveTask> createReceiveTask(ReceiveTask value) {
        return new JAXBElement<ReceiveTask>(_ReceiveTask_QNAME, ReceiveTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "conversation", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "conversationNode")
    public JAXBElement<Conversation> createConversation(Conversation value) {
        return new JAXBElement<Conversation>(_Conversation_QNAME, Conversation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "implicitThrowEvent", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ImplicitThrowEvent> createImplicitThrowEvent(ImplicitThrowEvent value) {
        return new JAXBElement<ImplicitThrowEvent>(_ImplicitThrowEvent_QNAME, ImplicitThrowEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "inclusiveGateway", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<InclusiveGateway> createInclusiveGateway(InclusiveGateway value) {
        return new JAXBElement<InclusiveGateway>(_InclusiveGateway_QNAME, InclusiveGateway.class, null, value);
    }
    

    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "intermediateCatchEvent", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<IntermediateCatchEvent> createIntermediateCatchEvent(IntermediateCatchEvent value) {
        return new JAXBElement<IntermediateCatchEvent>(_IntermediateCatchEvent_QNAME, IntermediateCatchEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "outputSet")
    public JAXBElement<OutputSet> createOutputSet(OutputSet value) {
        return new JAXBElement<OutputSet>(_OutputSet_QNAME, OutputSet.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "loopCharacteristics")
    public JAXBElement<LoopCharacteristics> createLoopCharacteristics(LoopCharacteristics value) {
        return new JAXBElement<LoopCharacteristics>(_LoopCharacteristics_QNAME, LoopCharacteristics.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "relationship")
    public JAXBElement<Relationship> createRelationship(Relationship value) {
        return new JAXBElement<Relationship>(_Relationship_QNAME, Relationship.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "process", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Process> createProcess(Process value) {
        return new JAXBElement<Process>(_Process_QNAME, Process.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "extension")
    public JAXBElement<Extension> createExtension(Extension value) {
        return new JAXBElement<Extension>(_Extension_QNAME, Extension.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "conditionalEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<ConditionalEventDefinition> createConditionalEventDefinition(ConditionalEventDefinition value) {
        return new JAXBElement<ConditionalEventDefinition>(_ConditionalEventDefinition_QNAME, ConditionalEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "assignment")
    public JAXBElement<Assignment> createAssignment(Assignment value) {
        return new JAXBElement<Assignment>(_Assignment_QNAME, Assignment.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "artifact")
    public JAXBElement<Artifact> createArtifact(Artifact value) {
        return new JAXBElement<Artifact>(_Artifact_QNAME, Artifact.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "flowNode")
    public JAXBElement<FlowNode> createFlowNode(FlowNode value) {
        return new JAXBElement<FlowNode>(_FlowNode_QNAME, FlowNode.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "endPoint", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<EndPoint> createEndPoint(EndPoint value) {
        return new JAXBElement<EndPoint>(_EndPoint_QNAME, EndPoint.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "messageFlow")
    public JAXBElement<MessageFlow> createMessageFlow(MessageFlow value) {
        return new JAXBElement<MessageFlow>(_MessageFlow_QNAME, MessageFlow.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "subProcess", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<SubProcess> createSubProcess(SubProcess value) {
        return new JAXBElement<SubProcess>(_SubProcess_QNAME, SubProcess.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "endEvent", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<EndEvent> createEndEvent(EndEvent value) {
        return new JAXBElement<EndEvent>(_EndEvent_QNAME, EndEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "documentation")
    public JAXBElement<Documentation> createDocumentation(Documentation value) {
        return new JAXBElement<Documentation>(_Documentation_QNAME, Documentation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "baseElement")
    public JAXBElement<BaseElement> createBaseElement(BaseElement value) {
        return new JAXBElement<BaseElement>(_BaseElement_QNAME, BaseElement.class, null, value);
    }



    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "terminateEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<TerminateEventDefinition> createTerminateEventDefinition(TerminateEventDefinition value) {
        return new JAXBElement<TerminateEventDefinition>(_TerminateEventDefinition_QNAME, TerminateEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "eventBasedGateway", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<EventBasedGateway> createEventBasedGateway(EventBasedGateway value) {
        return new JAXBElement<EventBasedGateway>(_EventBasedGateway_QNAME, EventBasedGateway.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "globalScriptTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<GlobalScriptTask> createGlobalScriptTask(GlobalScriptTask value) {
        return new JAXBElement<GlobalScriptTask>(_GlobalScriptTask_QNAME, GlobalScriptTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "timerEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<TimerEventDefinition> createTimerEventDefinition(TimerEventDefinition value) {
        return new JAXBElement<TimerEventDefinition>(_TimerEventDefinition_QNAME, TimerEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "complexGateway", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ComplexGateway> createComplexGateway(ComplexGateway value) {
        return new JAXBElement<ComplexGateway>(_ComplexGateway_QNAME, ComplexGateway.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "manualTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ManualTask> createManualTask(ManualTask value) {
        return new JAXBElement<ManualTask>(_ManualTask_QNAME, ManualTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "callableElement")
    public JAXBElement<CallableElement> createCallableElement(CallableElement value) {
        return new JAXBElement<CallableElement>(_CallableElement_QNAME, CallableElement.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "cancelEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<CancelEventDefinition> createCancelEventDefinition(CancelEventDefinition value) {
        return new JAXBElement<CancelEventDefinition>(_CancelEventDefinition_QNAME, CancelEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "serviceTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ServiceTask> createServiceTask(ServiceTask value) {
        return new JAXBElement<ServiceTask>(_ServiceTask_QNAME, ServiceTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "subChoreography", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<SubChoreography> createSubChoreography(SubChoreography value) {
        return new JAXBElement<SubChoreography>(_SubChoreography_QNAME, SubChoreography.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "correlationSubscription")
    public JAXBElement<CorrelationSubscription> createCorrelationSubscription(CorrelationSubscription value) {
        return new JAXBElement<CorrelationSubscription>(_CorrelationSubscription_QNAME, CorrelationSubscription.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "choreographyActivity")
    public JAXBElement<ChoreographyActivity> createChoreographyActivity(ChoreographyActivity value) {
        return new JAXBElement<ChoreographyActivity>(_ChoreographyActivity_QNAME, ChoreographyActivity.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "event", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<Event> createEvent(Event value) {
        return new JAXBElement<Event>(_Event_QNAME, Event.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "globalConversation", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "collaboration")
    public JAXBElement<GlobalConversation> createGlobalConversation(GlobalConversation value) {
        return new JAXBElement<GlobalConversation>(_GlobalConversation_QNAME, GlobalConversation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "import")
    public JAXBElement<Import> createImport(Import value) {
        return new JAXBElement<Import>(_Import_QNAME, Import.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "resourceAssignmentExpression")
    public JAXBElement<ResourceAssignmentExpression> createResourceAssignmentExpression(ResourceAssignmentExpression value) {
        return new JAXBElement<ResourceAssignmentExpression>(_ResourceAssignmentExpression_QNAME, ResourceAssignmentExpression.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "eventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<EventDefinition> createEventDefinition(EventDefinition value) {
        return new JAXBElement<EventDefinition>(_EventDefinition_QNAME, EventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "monitoring")
    public JAXBElement<Monitoring> createMonitoring(Monitoring value) {
        return new JAXBElement<Monitoring>(_Monitoring_QNAME, Monitoring.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "throwEvent")
    public JAXBElement<ThrowEvent> createThrowEvent(ThrowEvent value) {
        return new JAXBElement<ThrowEvent>(_ThrowEvent_QNAME, ThrowEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "itemDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<ItemDefinition> createItemDefinition(ItemDefinition value) {
        return new JAXBElement<ItemDefinition>(_ItemDefinition_QNAME, ItemDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "adHocSubProcess", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<AdHocSubProcess> createAdHocSubProcess(AdHocSubProcess value) {
        return new JAXBElement<AdHocSubProcess>(_AdHocSubProcess_QNAME, AdHocSubProcess.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "globalUserTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<GlobalUserTask> createGlobalUserTask(GlobalUserTask value) {
        return new JAXBElement<GlobalUserTask>(_GlobalUserTask_QNAME, GlobalUserTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "category", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "startEvent", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<StartEvent> createStartEvent(StartEvent value) {
        return new JAXBElement<StartEvent>(_StartEvent_QNAME, StartEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "participant")
    public JAXBElement<Participant> createParticipant(Participant value) {
        return new JAXBElement<Participant>(_Participant_QNAME, Participant.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "performer", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "resourceRole")
    public JAXBElement<Performer> createPerformer(Performer value) {
        return new JAXBElement<Performer>(_Performer_QNAME, Performer.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "formalExpression", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "expression")
    public JAXBElement<FormalExpression> createFormalExpression(FormalExpression value) {
        return new JAXBElement<FormalExpression>(_FormalExpression_QNAME, FormalExpression.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "messageEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<MessageEventDefinition> createMessageEventDefinition(MessageEventDefinition value) {
        return new JAXBElement<MessageEventDefinition>(_MessageEventDefinition_QNAME, MessageEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "catchEvent")
    public JAXBElement<CatchEvent> createCatchEvent(CatchEvent value) {
        return new JAXBElement<CatchEvent>(_CatchEvent_QNAME, CatchEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataOutputAssociation")
    public JAXBElement<DataOutputAssociation> createDataOutputAssociation(DataOutputAssociation value) {
        return new JAXBElement<DataOutputAssociation>(_DataOutputAssociation_QNAME, DataOutputAssociation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataObjectReference", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<DataObjectReference> createDataObjectReference(DataObjectReference value) {
        return new JAXBElement<DataObjectReference>(_DataObjectReference_QNAME, DataObjectReference.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "boundaryEvent", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<BoundaryEvent> createBoundaryEvent(BoundaryEvent value) {
        return new JAXBElement<BoundaryEvent>(_BoundaryEvent_QNAME, BoundaryEvent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "participantAssociation")
    public JAXBElement<ParticipantAssociation> createParticipantAssociation(ParticipantAssociation value) {
        return new JAXBElement<ParticipantAssociation>(_ParticipantAssociation_QNAME, ParticipantAssociation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "sendTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<SendTask> createSendTask(SendTask value) {
        return new JAXBElement<SendTask>(_SendTask_QNAME, SendTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "categoryValue")
    public JAXBElement<CategoryValue> createCategoryValue(CategoryValue value) {
        return new JAXBElement<CategoryValue>(_CategoryValue_QNAME, CategoryValue.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "choreography", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "collaboration")
    public JAXBElement<Choreography> createChoreography(Choreography value) {
        return new JAXBElement<Choreography>(_Choreography_QNAME, Choreography.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "globalChoreographyTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "choreography")
    public JAXBElement<GlobalChoreographyTask> createGlobalChoreographyTask(GlobalChoreographyTask value) {
        return new JAXBElement<GlobalChoreographyTask>(_GlobalChoreographyTask_QNAME, GlobalChoreographyTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "callChoreography", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<CallChoreography> createCallChoreography(CallChoreography value) {
        return new JAXBElement<CallChoreography>(_CallChoreography_QNAME, CallChoreography.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "multiInstanceLoopCharacteristics", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "loopCharacteristics")
    public JAXBElement<MultiInstanceLoopCharacteristics> createMultiInstanceLoopCharacteristics(MultiInstanceLoopCharacteristics value) {
        return new JAXBElement<MultiInstanceLoopCharacteristics>(_MultiInstanceLoopCharacteristics_QNAME, MultiInstanceLoopCharacteristics.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "potentialOwner", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "performer")
    public JAXBElement<PotentialOwner> createPotentialOwner(PotentialOwner value) {
        return new JAXBElement<PotentialOwner>(_PotentialOwner_QNAME, PotentialOwner.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "correlationPropertyBinding")
    public JAXBElement<CorrelationPropertyBinding> createCorrelationPropertyBinding(CorrelationPropertyBinding value) {
        return new JAXBElement<CorrelationPropertyBinding>(_CorrelationPropertyBinding_QNAME, CorrelationPropertyBinding.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "signal", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Signal> createSignal(Signal value) {
        return new JAXBElement<Signal>(_Signal_QNAME, Signal.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "userTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<UserTask> createUserTask(UserTask value) {
        return new JAXBElement<UserTask>(_UserTask_QNAME, UserTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "parallelGateway", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ParallelGateway> createParallelGateway(ParallelGateway value) {
        return new JAXBElement<ParallelGateway>(_ParallelGateway_QNAME, ParallelGateway.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "lane")
    public JAXBElement<Lane> createLane(Lane value) {
        return new JAXBElement<Lane>(_Lane_QNAME, Lane.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "subConversation", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "conversationNode")
    public JAXBElement<SubConversation> createSubConversation(SubConversation value) {
        return new JAXBElement<SubConversation>(_SubConversation_QNAME, SubConversation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "baseElementWithMixedContent")
    public JAXBElement<BaseElementWithMixedContent> createBaseElementWithMixedContent(BaseElementWithMixedContent value) {
        return new JAXBElement<BaseElementWithMixedContent>(_BaseElementWithMixedContent_QNAME, BaseElementWithMixedContent.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataStore", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<DataStore> createDataStore(DataStore value) {
        return new JAXBElement<DataStore>(_DataStore_QNAME, DataStore.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "signalEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<SignalEventDefinition> createSignalEventDefinition(SignalEventDefinition value) {
        return new JAXBElement<SignalEventDefinition>(_SignalEventDefinition_QNAME, SignalEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "rootElement")
    public JAXBElement<RootElement> createRootElement(RootElement value) {
        return new JAXBElement<RootElement>(_RootElement_QNAME, RootElement.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataState")
    public JAXBElement<DataState> createDataState(DataState value) {
        return new JAXBElement<DataState>(_DataState_QNAME, DataState.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "correlationPropertyRetrievalExpression")
    public JAXBElement<CorrelationPropertyRetrievalExpression> createCorrelationPropertyRetrievalExpression(CorrelationPropertyRetrievalExpression value) {
        return new JAXBElement<CorrelationPropertyRetrievalExpression>(_CorrelationPropertyRetrievalExpression_QNAME, CorrelationPropertyRetrievalExpression.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "ioSpecification")
    public JAXBElement<InputOutputSpecification> createIoSpecification(InputOutputSpecification value) {
        return new JAXBElement<InputOutputSpecification>(_IoSpecification_QNAME, InputOutputSpecification.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "conversationAssociation")
    public JAXBElement<ConversationAssociation> createConversationAssociation(ConversationAssociation value) {
        return new JAXBElement<ConversationAssociation>(_ConversationAssociation_QNAME, ConversationAssociation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "laneSet")
    public JAXBElement<LaneSet> createLaneSet(LaneSet value) {
        return new JAXBElement<LaneSet>(_LaneSet_QNAME, LaneSet.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "activity")
    public JAXBElement<Activity> createActivity(Activity value) {
        return new JAXBElement<Activity>(_Activity_QNAME, Activity.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "globalTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<GlobalTask> createGlobalTask(GlobalTask value) {
        return new JAXBElement<GlobalTask>(_GlobalTask_QNAME, GlobalTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "error", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Error> createError(Error value) {
        return new JAXBElement<Error>(_Error_QNAME, Error.class, null, value);
    }



    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "task", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<Task> createTask(Task value) {
        return new JAXBElement<Task>(_Task_QNAME, Task.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "resource", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Resource> createResource(Resource value) {
        return new JAXBElement<Resource>(_Resource_QNAME, Resource.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "interface", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Interface> createInterface(Interface value) {
        return new JAXBElement<Interface>(_Interface_QNAME, Interface.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "correlationKey")
    public JAXBElement<CorrelationKey> createCorrelationKey(CorrelationKey value) {
        return new JAXBElement<CorrelationKey>(_CorrelationKey_QNAME, CorrelationKey.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "rendering")
    public JAXBElement<Rendering> createRendering(Rendering value) {
        return new JAXBElement<Rendering>(_Rendering_QNAME, Rendering.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "resourceParameterBinding")
    public JAXBElement<ResourceParameterBinding> createResourceParameterBinding(ResourceParameterBinding value) {
        return new JAXBElement<ResourceParameterBinding>(_ResourceParameterBinding_QNAME, ResourceParameterBinding.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "exclusiveGateway", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ExclusiveGateway> createExclusiveGateway(ExclusiveGateway value) {
        return new JAXBElement<ExclusiveGateway>(_ExclusiveGateway_QNAME, ExclusiveGateway.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "correlationProperty", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<CorrelationProperty> createCorrelationProperty(CorrelationProperty value) {
        return new JAXBElement<CorrelationProperty>(_CorrelationProperty_QNAME, CorrelationProperty.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "message", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Message> createMessage(Message value) {
        return new JAXBElement<Message>(_Message_QNAME, Message.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataStoreReference", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<DataStoreReference> createDataStoreReference(DataStoreReference value) {
        return new JAXBElement<DataStoreReference>(_DataStoreReference_QNAME, DataStoreReference.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "globalManualTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<GlobalManualTask> createGlobalManualTask(GlobalManualTask value) {
        return new JAXBElement<GlobalManualTask>(_GlobalManualTask_QNAME, GlobalManualTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "escalation", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<Escalation> createEscalation(Escalation value) {
        return new JAXBElement<Escalation>(_Escalation_QNAME, Escalation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "callActivity", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<CallActivity> createCallActivity(CallActivity value) {
        return new JAXBElement<CallActivity>(_CallActivity_QNAME, CallActivity.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "textAnnotation", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "artifact")
    public JAXBElement<TextAnnotation> createTextAnnotation(TextAnnotation value) {
        return new JAXBElement<TextAnnotation>(_TextAnnotation_QNAME, TextAnnotation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "group", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "artifact")
    public JAXBElement<Group> createGroup(Group value) {
        return new JAXBElement<Group>(_Group_QNAME, Group.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "auditing")
    public JAXBElement<Auditing> createAuditing(Auditing value) {
        return new JAXBElement<Auditing>(_Auditing_QNAME, Auditing.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataOutput")
    public JAXBElement<DataOutput> createDataOutput(DataOutput value) {
        return new JAXBElement<DataOutput>(_DataOutput_QNAME, DataOutput.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "expression")
    public JAXBElement<Expression> createExpression(Expression value) {
        return new JAXBElement<Expression>(_Expression_QNAME, Expression.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "transaction", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<Transaction> createTransaction(Transaction value) {
        return new JAXBElement<Transaction>(_Transaction_QNAME, Transaction.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "choreographyTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<ChoreographyTask> createChoreographyTask(ChoreographyTask value) {
        return new JAXBElement<ChoreographyTask>(_ChoreographyTask_QNAME, ChoreographyTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "gateway")
    public JAXBElement<Gateway> createGateway(Gateway value) {
        return new JAXBElement<Gateway>(_Gateway_QNAME, Gateway.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "resourceRole")
    public JAXBElement<ResourceRole> createResourceRole(ResourceRole value) {
        return new JAXBElement<ResourceRole>(_ResourceRole_QNAME, ResourceRole.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "partnerEntity", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<PartnerEntity> createPartnerEntity(PartnerEntity value) {
        return new JAXBElement<PartnerEntity>(_PartnerEntity_QNAME, PartnerEntity.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "partnerRole", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "rootElement")
    public JAXBElement<PartnerRole> createPartnerRole(PartnerRole value) {
        return new JAXBElement<PartnerRole>(_PartnerRole_QNAME, PartnerRole.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "businessRuleTask", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<BusinessRuleTask> createBusinessRuleTask(BusinessRuleTask value) {
        return new JAXBElement<BusinessRuleTask>(_BusinessRuleTask_QNAME, BusinessRuleTask.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "ioBinding")
    public JAXBElement<InputOutputBinding> createIoBinding(InputOutputBinding value) {
        return new JAXBElement<InputOutputBinding>(_IoBinding_QNAME, InputOutputBinding.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "flowElement")
    public JAXBElement<FlowElement> createFlowElement(FlowElement value) {
        return new JAXBElement<FlowElement>(_FlowElement_QNAME, FlowElement.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataObject", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "flowElement")
    public JAXBElement<DataObject> createDataObject(DataObject value) {
        return new JAXBElement<DataObject>(_DataObject_QNAME, DataObject.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "linkEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<LinkEventDefinition> createLinkEventDefinition(LinkEventDefinition value) {
        return new JAXBElement<LinkEventDefinition>(_LinkEventDefinition_QNAME, LinkEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "resourceParameter")
    public JAXBElement<ResourceParameter> createResourceParameter(ResourceParameter value) {
        return new JAXBElement<ResourceParameter>(_ResourceParameter_QNAME, ResourceParameter.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "text")
    public JAXBElement<Text> createText(Text value) {
        return new JAXBElement<Text>(_Text_QNAME, Text.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "association", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "artifact")
    public JAXBElement<Association> createAssociation(Association value) {
        return new JAXBElement<Association>(_Association_QNAME, Association.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "callConversation", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "conversationNode")
    public JAXBElement<CallConversation> createCallConversation(CallConversation value) {
        return new JAXBElement<CallConversation>(_CallConversation_QNAME, CallConversation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "escalationEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<EscalationEventDefinition> createEscalationEventDefinition(EscalationEventDefinition value) {
        return new JAXBElement<EscalationEventDefinition>(_EscalationEventDefinition_QNAME, EscalationEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "definitions")
    public JAXBElement<Definitions> createDefinitions(Definitions value) {
        return new JAXBElement<Definitions>(_Definitions_QNAME, Definitions.class, null, value);
    }



    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "property")
    public JAXBElement<Property> createProperty(Property value) {
        return new JAXBElement<Property>(_Property_QNAME, Property.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "script")
    public JAXBElement<Script> createScript(Script value) {
        return new JAXBElement<Script>(_Script_QNAME, Script.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataInput")
    public JAXBElement<DataInput> createDataInput(DataInput value) {
        return new JAXBElement<DataInput>(_DataInput_QNAME, DataInput.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "conversationNode")
    public JAXBElement<ConversationNode> createConversationNode(ConversationNode value) {
        return new JAXBElement<ConversationNode>(_ConversationNode_QNAME, ConversationNode.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "compensateEventDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "eventDefinition")
    public JAXBElement<CompensateEventDefinition> createCompensateEventDefinition(CompensateEventDefinition value) {
        return new JAXBElement<CompensateEventDefinition>(_CompensateEventDefinition_QNAME, CompensateEventDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "complexBehaviorDefinition")
    public JAXBElement<ComplexBehaviorDefinition> createComplexBehaviorDefinition(ComplexBehaviorDefinition value) {
        return new JAXBElement<ComplexBehaviorDefinition>(_ComplexBehaviorDefinition_QNAME, ComplexBehaviorDefinition.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "conversationLink")
    public JAXBElement<ConversationLink> createConversationLink(ConversationLink value) {
        return new JAXBElement<ConversationLink>(_ConversationLink_QNAME, ConversationLink.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "messageFlowAssociation")
    public JAXBElement<MessageFlowAssociation> createMessageFlowAssociation(MessageFlowAssociation value) {
        return new JAXBElement<MessageFlowAssociation>(_MessageFlowAssociation_QNAME, MessageFlowAssociation.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "standardLoopCharacteristics", substitutionHeadNamespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", substitutionHeadName = "loopCharacteristics")
    public JAXBElement<StandardLoopCharacteristics> createStandardLoopCharacteristics(StandardLoopCharacteristics value) {
        return new JAXBElement<StandardLoopCharacteristics>(_StandardLoopCharacteristics_QNAME, StandardLoopCharacteristics.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "sourceRef", scope = DataAssociation.class)
    @XmlIDREF
    public JAXBElement<Object> createTDataAssociationSourceRef(Object value) {
        return new JAXBElement<Object>(_TDataAssociationSourceRef_QNAME, Object.class, DataAssociation.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataOutputRefs", scope = OutputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTOutputSetDataOutputRefs(Object value) {
        return new JAXBElement<Object>(_TOutputSetDataOutputRefs_QNAME, Object.class, OutputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "optionalOutputRefs", scope = OutputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTOutputSetOptionalOutputRefs(Object value) {
        return new JAXBElement<Object>(_TOutputSetOptionalOutputRefs_QNAME, Object.class, OutputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "whileExecutingOutputRefs", scope = OutputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTOutputSetWhileExecutingOutputRefs(Object value) {
        return new JAXBElement<Object>(_TOutputSetWhileExecutingOutputRefs_QNAME, Object.class, OutputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "inputSetRefs", scope = OutputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTOutputSetInputSetRefs(Object value) {
        return new JAXBElement<Object>(_TOutputSetInputSetRefs_QNAME, Object.class, OutputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "whileExecutingInputRefs", scope = InputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTInputSetWhileExecutingInputRefs(Object value) {
        return new JAXBElement<Object>(_TInputSetWhileExecutingInputRefs_QNAME, Object.class, InputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "outputSetRefs", scope = InputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTInputSetOutputSetRefs(Object value) {
        return new JAXBElement<Object>(_TInputSetOutputSetRefs_QNAME, Object.class, InputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "optionalInputRefs", scope = InputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTInputSetOptionalInputRefs(Object value) {
        return new JAXBElement<Object>(_TInputSetOptionalInputRefs_QNAME, Object.class, InputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "dataInputRefs", scope = InputSet.class)
    @XmlIDREF
    public JAXBElement<Object> createTInputSetDataInputRefs(Object value) {
        return new JAXBElement<Object>(_TInputSetDataInputRefs_QNAME, Object.class, InputSet.class, value);
    }


    @XmlElementDecl(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "flowNodeRef", scope = Lane.class)
    @XmlIDREF
    public JAXBElement<Object> createTLaneFlowNodeRef(Object value) {
        return new JAXBElement<Object>(_TLaneFlowNodeRef_QNAME, Object.class, Lane.class, value);
    }

}
