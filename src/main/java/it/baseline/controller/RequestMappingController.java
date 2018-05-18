package it.baseline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import it.baseline.model.Mmg;
import it.baseline.model.Paziente;
import it.baseline.service.mmg.MmgService;
import it.baseline.service.Paziente.PazienteService;
import it.baseline.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class RequestMappingController {

    @Autowired
    private PazienteService pazienteService;

    @Autowired
    private MmgService mmgService;

    @Autowired
    private UserService userService;

	ModelAndView modelAndView=new ModelAndView();

	@RequestMapping(value = "/dashboard/tabulato", method = RequestMethod.GET)
	public String tabulatoPage(ModelMap model) {
        User user = null;
		model.addAttribute("user", getPrincipal());
		return "tabulato";
	}

    public static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }

    @RequestMapping(value = "/dashboard/getUtenti", method = RequestMethod.GET, headers="Accept=*/*", produces="application/json")
    public @ResponseBody String getUtentiService() {
        List<Paziente> paziente = pazienteService.getPazienti();

        Gson gson = new Gson();
        String json = gson.toJson(paziente);

        JSONObject obj = new JSONObject();
        obj.put("data", json);

        String a = obj.toJSONString();

        a = a.replace("\\","");

        a = new StringBuilder(a)
                .deleteCharAt(a.length() - 2)
                .toString();

        return replaceCharAt(a, 8, ' ');
    }

	@RequestMapping(value = "/dashboard/updateUtenti", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateUtenti(@ModelAttribute("updatePaziente")Paziente paziente) {

        Boolean result = pazienteService.updatePaziente(paziente);

        String message;

        if(!result){
            message = "Aggiornamento Fallito";
            return new ModelAndView("redirect:" + "/dashboard/tabulato", "paziente", message);
        }
        else{
            message = "Aggiornamento Completato";
            return new ModelAndView("redirect:" + "/dashboard/tabulato", "paziente", message);
        }

	}

    @RequestMapping(value = "/dashboard/deleteUtenti", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteUtenti(@ModelAttribute("deletePaziente")Paziente paziente) {

        Boolean result = pazienteService.deletePaziente(paziente);

        String message;

        if(!result){
            message = "Eliminazione Fallita";
            return new ModelAndView("redirect:" + "/dashboard/tabulato", "paziente", message);
        }
        else{
            message = "Eliminazione Completata";
            return new ModelAndView("redirect:" + "/dashboard/tabulato", "paziente", message);
        }

    }

    @RequestMapping(value = "/dashboard/presaIncarico", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView presaIncarico(@ModelAttribute("presaPaziente")Paziente paziente) {

        String message;

	    int idPaziente = paziente.getId();

        Mmg mmg = mmgService.cercaPaziente(idPaziente);

        if(mmg == null){

            String userName = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                userName = ((UserDetails)principal).getUsername();
            } else {
                userName = principal.toString();
            }

            it.baseline.model.User user = userService.findBySso(userName);

            Mmg mmg1 = mmgService.insertPaziente(idPaziente,user.getId());

            if(mmg1 == null){
                message = "Errore nella presa in carico";
                return new ModelAndView("redirect:" + "/dashboard/tabulato", "paziente", message);
            }else{
                message = "Paziente preso in carico con successo";
                return new ModelAndView("redirect:" + "/dashboard/tabulato", "paziente", message);
            }
        }
        else{
            message = "PazienteSi";
            return new ModelAndView("redirect:" + "/dashboard/tabulato", "paziente", message);
        }

    }

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "navigation";
	}

	@RequestMapping(value = "/dashboard/supporto", method = RequestMethod.GET)
	public String supportoPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "email";
	}

	@RequestMapping(value = "/dashboard/contatti", method = RequestMethod.GET)
	public String contattiPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "contatti";
	}

    @RequestMapping(value = "/dashboard/primaValutazione/approfondimento", method = RequestMethod.GET)
    public String approfondimentoPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "approfondimento";
    }

    @RequestMapping(value = "/dashboard/primaValutazione", method = RequestMethod.GET)
    public String primaValutazionePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "primaValutazione";
    }

	@RequestMapping(value = "/dashboard/secondaValutazione", method = RequestMethod.GET)
	public String secondaValutazionePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "secondaValutazione";
	}

    @RequestMapping(value = "/dashboard/cercaPaziente", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView infoPaziente(@ModelAttribute("cercaPaziente") Paziente paziente) {
        paziente = pazienteService.cercaCodiceFiscale(paziente.getCodiceFiscale().toUpperCase());
        if(paziente == null){
        	String message = "Nessun Paziente";
			return new ModelAndView("redirect:" + "/dashboard/infoPaziente", "paziente", message);
		}
		else{
			return new ModelAndView("redirect:" + "/dashboard/infoPaziente", "paziente", paziente.toString());
		}

    }

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginErrorPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "login-error";
	}

	@RequestMapping(value = "/accessDeniedPage", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDeniedPage";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	private String getPrincipal(){
		String userName = null;
		String authorities = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
            authorities = String.valueOf(((UserDetails)principal).getAuthorities());
		} else {
			userName = principal.toString();
            authorities = principal.toString();
		}
		return authorities;
	}


}