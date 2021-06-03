package br.com.fiap.usuarios.service;

import java.util.List;

import br.com.fiap.usuarios.dto.UsuariosDto;

public interface UsuariosService {

	UsuariosDto salvarUsuarios(UsuariosDto usuarioDto);

	List<UsuariosDto> listarUsuarios();

	UsuariosDto editarUsuarios(Long id);

	void excluirUsuarios(Long id);

}
