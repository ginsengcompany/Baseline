package it.baseline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.baseline.model.Paziente;
import it.baseline.service.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RequestMappingController {

    @Autowired
    private PazienteService pazienteService;

	ModelAndView modelAndView=new ModelAndView();


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

	@RequestMapping(value = "/dashboard/infoPaziente", method = RequestMethod.GET)
	public String infoPazientePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "infoPaziente";
	}

    @RequestMapping(value = "/dashboard/infoPaziente", method = RequestMethod.POST)
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
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}


}