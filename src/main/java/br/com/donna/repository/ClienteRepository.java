package br.com.donna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.donna.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
