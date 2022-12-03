package br.com.donna.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.donna.model.Cliente;
import br.com.donna.model.Pacote;
import br.com.donna.repository.PacoteRepository;

@Controller
@RequestMapping("/pacote")
public class PacoteController {

	@Autowired
    private PacoteRepository pacoteRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("pacote/home.html");

        List<Pacote> pacote = pacoteRepository.findAll();
		modelAndView.addObject("pacote", pacote);
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("pacote/cadastro");

        modelAndView.addObject("pacote", new Pacote());

       
        return modelAndView;
    }
    
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Pacote pacote) throws IOException {

				ModelAndView modelAndView = new ModelAndView("redirect:/pacote");

		pacoteRepository.save(pacote);

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView comprar(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("comprar.html");

		Pacote pacote = pacoteRepository.getOne(id);
		modelAndView.addObject("pacote", pacote);

		return modelAndView;
	}

		
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("pacote/editar");

        modelAndView.addObject("pacote", pacoteRepository.getOne(id));
        
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String salvar(Pacote pacote) {
    
    	
        pacoteRepository.save(pacote);

        return "redirect:/pacote";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        pacoteRepository.deleteById(id);

        return "redirect:/pacote";
    }
    
}
