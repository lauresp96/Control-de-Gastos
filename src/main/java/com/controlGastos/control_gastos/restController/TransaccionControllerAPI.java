package com.controlGastos.control_gastos.restController;

import com.controlGastos.control_gastos.model.Transaccion;
import com.controlGastos.control_gastos.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionControllerAPI {

    @Autowired
    private TransaccionService transaccionService;

    @PostMapping
    public ResponseEntity<Transaccion> registrarTransaccion(@RequestBody Transaccion transaccion) {
        return ResponseEntity.ok(transaccionService.registrarTransaccion(transaccion));
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Transaccion>> listarTransacciones(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(transaccionService.listarTransacciones(usuarioId));
    }

    @GetMapping("/balance/{usuarioId}")
    public ResponseEntity<Double> calcularBalance(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(transaccionService.calcularBalance(usuarioId));
    }
}
