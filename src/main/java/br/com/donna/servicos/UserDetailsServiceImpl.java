package br.com.donna.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.donna.model.UserDetailsImpl;
import br.com.donna.model.Usuario;
import br.com.donna.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

	 @Autowired
	    private UsuarioRepository usuarioRepository;

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Usuario usuario = usuarioRepository.findByEmail(email);
//	            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

	        return new UserDetailsImpl(usuario);
	    }
	    
	    
}
