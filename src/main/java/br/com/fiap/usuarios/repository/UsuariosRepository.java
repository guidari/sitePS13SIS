package br.com.fiap.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.usuarios.entity.UsuariosEntity;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long>{

}
