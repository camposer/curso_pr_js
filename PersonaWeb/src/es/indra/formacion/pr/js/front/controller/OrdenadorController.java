package es.indra.formacion.pr.js.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ordenador/*")
public class OrdenadorController {
	@RequestMapping(value={"principal", ""})
	public String principal(Model model) {
		return "forward:/jsp/ordenador/principal.jsp";
	}
}
