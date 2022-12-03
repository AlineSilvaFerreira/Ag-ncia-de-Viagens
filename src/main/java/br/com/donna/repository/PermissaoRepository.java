package br.com.donna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.donna.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {

}
