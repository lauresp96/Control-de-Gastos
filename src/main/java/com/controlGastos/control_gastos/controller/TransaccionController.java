package com.controlGastos.control_gastos.controller;

import com.controlGastos.control_gastos.model.Transaccion;
import com.controlGastos.control_gastos.model.Usuario;
import com.controlGastos.control_gastos.service.TransaccionService;
import com.controlGastos.control_gastos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/transacciones")
    public String mostrarTransacciones(@RequestParam Long usuarioId, Model model) {
        List<Transaccion> transacciones = transaccionService.listarTransacciones(usuarioId);
        model.addAttribute("transacciones", transaccionService.listarTransacciones(usuarioId));
        model.addAttribute("balance", transaccionService.calcularBalance(usuarioId));

        // datos para grafico
        Map<String, Double> graficoDatos = new HashMap<>();
        for (Transaccion transaccion : transacciones) {
            graficoDatos.put(transaccion.getDescripcion(), transaccion.getMonto());
        }
        model.addAttribute("graficoDatos", graficoDatos);
        return "transacciones";
    }

    @GetMapping("/transacciones/nueva")
    public String mostrarFormularioNuevaTransaccion(Model model) {
        model.addAttribute("transaccion", new Transaccion());
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "transaccion_form";
    }

    @PostMapping("/transacciones/guardar")
    public String guradarTransaccion(Transaccion transaccion) {
        transaccionService.registrarTransaccion(transaccion);
        return "redirect:/transacciones?usuarioId=" + transaccion.getUsuario().getId();
    }
}
