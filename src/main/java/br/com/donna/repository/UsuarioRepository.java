package br.com.donna.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.donna.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	 Usuario findByEmail(String email);

}
