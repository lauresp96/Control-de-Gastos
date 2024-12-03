package com.controlGastos.control_gastos.service;

import com.controlGastos.control_gastos.model.TipoTransaccion;
import com.controlGastos.control_gastos.model.Transaccion;
import com.controlGastos.control_gastos.respository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;


    public Transaccion registrarTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public List<Transaccion> listarTransacciones(Long usuarioId) {
        return transaccionRepository.findByUsuarioId(usuarioId);
    }

    public Double calcularBalance(Long usuarioId) {
        List<Transaccion> transacciones = listarTransacciones(usuarioId);
        return transacciones.stream()
                .mapToDouble(t -> t.getTipo() == TipoTransaccion.INGRESO ? t.getMonto() : -t.getMonto()
                ).sum();
    } // Estudiar esto, para entender mejor.
}
