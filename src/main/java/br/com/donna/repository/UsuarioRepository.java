package br.com.donna.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.donna.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	 Optional<Usuario> findByEmail(String email);

}
