package br.com.fiap.usuarios.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.usuarios.dto.UsuariosDto;
import br.com.fiap.usuarios.entity.UsuariosEntity;
import br.com.fiap.usuarios.repository.UsuariosRepository;
import br.com.fiap.usuarios.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	UsuariosRepository repository;

	@Override
	public UsuariosDto salvarUsuarios(UsuariosDto usuarioDto) {
		UsuariosEntity entity = usuarioDto.toEntity();
		entity = repository.save(entity);
		UsuariosDto usuariosDto = fromUsuariosEntityToUsuariosDto(entity);
		return usuariosDto;
	}

	@Override
	public List<UsuariosDto> listarUsuarios() {

		List<UsuariosEntity> listaUsuariosEntity = repository.findAll();

		List<UsuariosDto> listaUsuariosDto = fromUsuariosEntityToUsuariosDto(listaUsuariosEntity);

		return listaUsuariosDto;
	}

	@Override
	public UsuariosDto editarUsuarios(Long id) {

		UsuariosEntity entity = repository.findById(id).get();

		UsuariosDto usuarioDto = fromUsuariosEntityToUsuariosDto(entity);

		return usuarioDto;
	}

	public UsuariosDto visualizar(Long id) {

		UsuariosEntity entity = repository.findById(id).get();

		UsuariosDto usuarioDto = fromUsuariosEntityToUsuariosDto(entity);

		return usuarioDto;
	}

	@Override
	public void excluirUsuarios(Long id) {
		repository.deleteById(id);
	}

	private UsuariosDto fromUsuariosEntityToUsuariosDto(UsuariosEntity entity) {
		UsuariosDto dto = new UsuariosDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setMateria(entity.getMateria());
		dto.setImagem(entity.getImagem());
		dto.setCusto(entity.getCusto());
		dto.setBiografia(entity.getBiografia());
		return dto;
	}

	private List<UsuariosDto> fromUsuariosEntityToUsuariosDto(List<UsuariosEntity> listaEntity) {
		List<UsuariosDto> listaConvidadoDto = new ArrayList<>();

		for (UsuariosEntity usuariosEntity : listaEntity) {
			UsuariosDto dto = new UsuariosDto();
			dto.setId(usuariosEntity.getId());
			dto.setNome(usuariosEntity.getNome());
			dto.setEmail(usuariosEntity.getEmail());
			dto.setMateria(usuariosEntity.getMateria());
			dto.setImagem(usuariosEntity.getImagem());
			dto.setCusto(usuariosEntity.getCusto());
			dto.setBiografia(usuariosEntity.getBiografia());

			listaConvidadoDto.add(dto);
		}
		return listaConvidadoDto;
	}

}
