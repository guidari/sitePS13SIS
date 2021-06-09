package br.com.fiap.usuarios.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.usuarios.dto.UsuariosDto;
import br.com.fiap.usuarios.entity.UsuariosEntity;
import br.com.fiap.usuarios.service.UsuariosService;

@Controller
public class UsuariosController {

	@Autowired
	private UsuariosService service;

	@PostMapping("/usuarios")
	public String salvarUsuarios(@Valid UsuariosDto usuarioDto, BindingResult result) {

		if (!result.hasErrors()) {
			service.salvarUsuarios(usuarioDto);
			return "redirect:/usuarios";
		}

		return "redirect:/usuarios";
	}

	@GetMapping("/")
	public ModelAndView home() {

		ModelAndView view = new ModelAndView("usuarios/home");

		return view;
	}

	@GetMapping("/faleConosco")
	public ModelAndView faleConosco() {

		ModelAndView view = new ModelAndView("/usuarios/faleConosco");

		return view;
	}

	@GetMapping("/usuarios")
	public ModelAndView listar() {

		ModelAndView view = new ModelAndView("usuarios/ListaUsuarios");

		List<UsuariosDto> usuarios = service.listarUsuarios();

		view.addObject("usuario", new UsuariosEntity());

		view.addObject("usuarios", usuarios);

		return view;
	}

	@GetMapping("/usuarios/{id}")
	public ModelAndView editar(@PathVariable Long id) {

		UsuariosDto usuario = service.editarUsuarios(id);

		ModelAndView view = new ModelAndView("usuarios/editar-usuario");

		view.addObject("usuario", usuario);

		return view;
	}
	
	@GetMapping("/infoUsuario/{id}")
	public ModelAndView visualizar(@PathVariable Long id) {

		UsuariosDto usuario = service.visualizar(id);

		ModelAndView view = new ModelAndView("usuarios/infoUsuario");

		view.addObject("usuario", usuario);

		return view;
	}


	@GetMapping("/usuarios/excluir/{id}")
	public String excluir(@PathVariable Long id) {

		service.excluirUsuarios(id);

		return "redirect:/usuarios";
	}

}
