package it.baseline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingController {


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

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "login-error";
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