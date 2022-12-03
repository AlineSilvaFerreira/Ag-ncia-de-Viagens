package br.com.donna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.donna.model.Cliente;
import br.com.donna.model.Pacote;
import br.com.donna.repository.PacoteRepository;

@Controller
public class PagsController {

	@Autowired
	private PacoteRepository pacoteRepository;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}

	@GetMapping("/promocoes")
	public ModelAndView promocoes() {
		ModelAndView modelAndView = new ModelAndView("promocoes");

		List<Pacote> pacote = pacoteRepository.findAll();
		modelAndView.addObject("pacote", pacote);
		return modelAndView;

	}
		
	@GetMapping("/destinos")
	public String destinos() {
		return "destinos";
	}

}
