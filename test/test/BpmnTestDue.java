/**
 *
 * @author sistoandolfi
 */

package test;

import it.gesan.bpmn.core.processdefinition.classes.Definitions;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class BpmnTestDue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        //scrittura();
        lettura();
    }
    
    private static void scrittura() throws JAXBException{
        JAXBContext ctx = JAXBContext.newInstance(Definitions.class);
        Definitions d = new Definitions();
        d.setId("Sisto");
        //d.setElement("Andolfi");
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //m.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new CustomNamespaceMapper());
        m.marshal(d, System.out);        
    }
    
    private static void lettura() throws JAXBException{
        //String pathFile = "/Users/sistoandolfi/Desktop/prova.xml";
        String pathFile = "C:\\Users\\Antonio Biondillo\\Desktop\\diagram.bpmn";
        JAXBContext jaxbContext = JAXBContext.newInstance(Definitions.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //jaxbUnmarshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new CustomNamespaceMapper());
        JAXBElement<Definitions> bpmn = (JAXBElement<Definitions>) jaxbUnmarshaller.unmarshal(new File(pathFile));
        Definitions definition = (Definitions) bpmn.getValue();
        System.out.println(definition.getRootElement().size()); 
        //System.out.println(bpmn.getRootElement().size());
        
    }

}

