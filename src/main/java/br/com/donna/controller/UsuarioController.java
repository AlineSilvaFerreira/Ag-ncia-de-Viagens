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

import br.com.donna.model.Usuario;
import br.com.donna.repository.ClienteRepository;
import br.com.donna.repository.PermissaoRepository;
import br.com.donna.repository.UsuarioRepository;
import br.com.donna.utils.SenhaUtils;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
//	@Autowired
//	private PermissaoRepository permissaoRepository;
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("usuario/home.html");

		List<Usuario> usuario = usuarioRepository.findAll();
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("usuario/cadastro");

		modelAndView.addObject("usuario", new Usuario());
		modelAndView.addObject("cliente", clienteRepository.findAll());
		//modelAndView.addObject("permissao", permissaoRepository.findAll());
		
		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario) throws IOException {
		String senhaEncriptada = SenhaUtils.encode(usuario.getSenha());
		
		usuario.setSenha(senhaEncriptada);
		usuarioRepository.save(usuario);

		return "redirect:/usuario";
		
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("usuario/editar");

		modelAndView.addObject("usuario", usuarioRepository.getOne(id));
		modelAndView.addObject("cliente", clienteRepository.findAll());
	//	modelAndView.addObject("permissao", permissaoRepository.findAll());

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public String editar(Usuario usuario, @PathVariable int id) {
			    
		usuarioRepository.save(usuario);

		return "redirect:/usuario";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable int id) {
		usuarioRepository.deleteById(id);

		return "redirect:/usuario";
	}

}
