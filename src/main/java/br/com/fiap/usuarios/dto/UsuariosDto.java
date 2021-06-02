package br.com.fiap.usuarios.dto;

import javax.validation.constraints.NotBlank;

import br.com.fiap.usuarios.entity.UsuariosEntity;

public class UsuariosDto {

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String email;

	@NotBlank
	private String materia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public UsuariosEntity toEntity() {
		UsuariosEntity entity = new UsuariosEntity();
		entity.setId(this.id);
		entity.setEmail(this.email);
		entity.setNome(this.nome);
		entity.setMateria(this.materia);
		return entity;
	}

}
