/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.api;

import it.gesan.bpmn.core.processdefinition.di.BPMNDiagram;
import it.gesan.module.icdix.presentation.IcdixPresentation;
import it.gesan.module.servizi.presentation.ServiziPresentation;
import it.gesan.module.servizi.vo.ServizioVO;
import it.gesan.module.utenti.presentation.UtentiPresentation;
import it.gesan.module.utenti.vo.UtenteVO;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import it.gesan.rdb.interfaces.IEsitoBean;
import it.gesan.security.UserInfo;
import it.pubbliweb.module.servizi.presentation.ComuniPresentation;
import it.pubbliweb.module.servizi.presentation.ProvincePresentation;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author sistoandolfi
 */
@Path("servizi")
public class ServiziResources {
    ObjectMapper mapper = new ObjectMapper();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaServizi() throws JSONException {
        IEsitoBean esito = ServiziPresentation.getLista(new ServizioVO());
        return Response.status(200).entity(esito).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(ServizioVO servizioVO) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        
        if(esito.getReturnValue() == ReturnValues.FOUND){
            UtenteVO utenteVO = (UtenteVO)esito.getObject();
            servizioVO.setCreateUser(utenteVO.getUsername());
            servizioVO.setUpdateUser(utenteVO.getUsername());
            
            esito = ServiziPresentation.salva(servizioVO);

            if(esito.getReturnValue() == ReturnValues.SAVED){
                esito.setEsito(true);
            }            
            //jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
        }
        //String utente = jsonUtente.toString();


        return Response.status(200).entity(esito).build();
    } 
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") String id, ServizioVO servizioVO) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        
        if(esito.getReturnValue() == ReturnValues.FOUND){
            UtenteVO utenteVO = (UtenteVO)esito.getObject();
            servizioVO.setPrimaryKey(id);
            servizioVO.setCreateUser(utenteVO.getUsername());
            servizioVO.setUpdateUser(utenteVO.getUsername());
            
            esito = ServiziPresentation.salva(servizioVO);

            if(esito.getReturnValue() == ReturnValues.SAVED){
                esito.setEsito(true);
            }            
            //jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
        }
        //String utente = jsonUtente.toString();


        return Response.status(200).entity(esito).build();
    } 
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        
        if(esito.getReturnValue() == ReturnValues.FOUND){
            UtenteVO utenteVO = (UtenteVO)esito.getObject();
            ServizioVO servizioVO = new ServizioVO();
            
            servizioVO.setPrimaryKey(id);
            
            esito = ServiziPresentation.delete(servizioVO);

            if(esito.getReturnValue() == ReturnValues.SAVED){
                esito.setEsito(true);
            }            
            //jsonUtente = new JSONObject(mapper.writeValueAsString(utenteVO));
        }
        //String utente = jsonUtente.toString();


        return Response.status(200).entity(esito).build();
    } 
    
    @GET
    @Path("province")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaProvince() throws JSONException {
        String returnValue = "{\"esito\":false, \"messaggio\":\"Manca il Codice Azienda\"}";
        String lista = ProvincePresentation.getLista();
        returnValue = "{\"esito\":true, \"messaggio\":\"Ok\", \"data\": " + lista + "}";
        return Response.status(200).entity(returnValue).build();
    }
    
    @GET
    @Path("icdix")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaIcdix() throws JSONException {
        //String returnValue = "{\"esito\":false, \"messaggio\":\"Manca il Codice Azienda\"}";
        EsitoBean esito = IcdixPresentation.getLista(null);
        return Response.status(200).entity(esito).build();
    }

    @GET
    @Path("comuni")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getListaComuni(@QueryParam("siglaProvincia") String siglaProvincia) throws JSONException {
        String returnValue;
        UserInfo userInfo = (UserInfo) securityContext.getUserPrincipal();
        if (siglaProvincia == null) {
            returnValue = "{\"esito\":false, \"messaggio\":\"Manca la 'siglaProvincia'\"}";
        } else {
            String lista = ComuniPresentation.getLista(siglaProvincia);
            returnValue = "{\"esito\":true, \"messaggio\":\"Ok\", \"data\": " + lista + "}";
        }
        return Response.status(200).entity(returnValue).build();
    }    
    
    @POST
    @Path("bpmn")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response readBPMN(ServizioVO servizioVO) throws JSONException, IOException {
        String username = securityContext.getUserPrincipal().getName();
        
        IEsitoBean esito = UtentiPresentation.getUtenteByUsername(username);
        //JSONObject jsonUtente = new JSONObject();
        
        String path = servizioVO.getDescrizioneServizio();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        
        if(esito.getReturnValue() == ReturnValues.FOUND){
            try {
			JAXBContext xpdlContext = JAXBContext.newInstance(it.gesan.bpmn.core.processdefinition.classes.Definitions.class); // Contexto JAXB con la clase que corresponde al root del xml 
			Unmarshaller unmarshallerXpdl = xpdlContext.createUnmarshaller();
			File file = new File(path);
			if(file.exists()){
				XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(path)); // XML reader que usara JAXB el cual apunta al archivo a leer
				JAXBElement<it.gesan.bpmn.core.processdefinition.classes.Definitions> jaxbPackage = unmarshallerXpdl.unmarshal(reader,it.gesan.bpmn.core.processdefinition.classes.Definitions.class); //Aca es cuando efectivamente des-serializa
				
				it.gesan.bpmn.core.processdefinition.classes.Definitions definitions = jaxbPackage.getValue(); // Aca obtengo el elemento root del xml 
				java.util.List<BPMNDiagram> diagrams = definitions.getBPMNDiagram();
				System.out.println(definitions.getTargetNamespace());
				
				for(BPMNDiagram diagram: diagrams){
					
					System.out.println("Id: " + diagram.getId());
					
				}
				
				
			}else{
				System.out.println(file.getAbsolutePath());					
			}
			
		} catch (JAXBException | FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            }
        }
        //String utente = jsonUtente.toString();


        return Response.status(200).entity(esito).build();
    }
}
