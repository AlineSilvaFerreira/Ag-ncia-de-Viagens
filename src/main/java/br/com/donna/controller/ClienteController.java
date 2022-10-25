package br.com.donna.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.donna.model.Cliente;
import br.com.donna.model.UF;
import br.com.donna.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	    @Autowired
	    private ClienteRepository clienteRepository;

	    @GetMapping
	    public ModelAndView home() {
	        ModelAndView modelAndView = new ModelAndView("cliente/home.html");

	        List<Cliente> cliente = clienteRepository.findAll();
			modelAndView.addObject("cliente", cliente);
	        return modelAndView;
	    }

	    @GetMapping("/cadastrar")
	    public ModelAndView cadastrar() {
	        ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

	        modelAndView.addObject("cliente", new Cliente());
	        modelAndView.addObject("ufs", UF.values());
	       
	        return modelAndView;
	    }
	    
		@PostMapping("/cadastrar")
		public ModelAndView cadastrar(Cliente cliente) throws IOException {

			ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

			clienteRepository.save(cliente);

			return modelAndView;
		}

	    @GetMapping("/{id}/editar")
	    public ModelAndView editar(@PathVariable int id) {
	        ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

	        modelAndView.addObject("cliente", clienteRepository.getOne(id));
	        modelAndView.addObject("ufs", UF.values());

	        return modelAndView;
	    }

	    @PostMapping("/{id}/editar")
	    public String salvar(Cliente cliente) {
	        clienteRepository.save(cliente);

	        return "redirect:/cliente";
	    }

	    @GetMapping("/{id}/excluir")
	    public String excluir(@PathVariable int id) {
	        clienteRepository.deleteById(id);

	        return "redirect:/cliente";
	    }
	    
	}
	