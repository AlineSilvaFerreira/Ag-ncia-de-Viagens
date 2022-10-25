package br.com.donna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagsController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	
	@GetMapping("/promocoes")
	public String promocoes() {
		return "promocoes";
	}
	
	@GetMapping("/destinos")
	public String destinos() {
		return "destinos";
	}	

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
