package com.controlGastos.control_gastos.controller;

import com.controlGastos.control_gastos.model.Usuario;
import com.controlGastos.control_gastos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioCreacionUsuaario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario_form";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/eliminar/{usuarioId}")
    public String eliminarUsuario(@PathVariable Long usuarioId) {
        usuarioService.eliminarUsuarioPorId(usuarioId);
        return "redirect:/usuarios";
    }
}
