package com.stand_vm.cl.stand_vm.controller;

import com.stand_vm.cl.stand_vm.model.Stand;
import com.stand_vm.cl.stand_vm.service.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/stands")
public class StandController {
    @Autowired
    private StandService standService;

    @GetMapping
    public ResponseEntity<List<Stand>> Listar() {
        List<Stand> stands = standService.findAll();
        if (stands.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stands, HttpStatus.OK);
    }
    // Otros métodos para manejar las operaciones CRUD (crear, actualizar, eliminar) pueden ir aquí

    @PostMapping
    public ResponseEntity<Stand> crearStand(Stand stand) {
        Stand nuevoStand = standService.save(stand);
        return new ResponseEntity<>(nuevoStand, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stand> obtenerStandPorId(Long id) {
        Stand stand = standService.findById(id);
        if (stand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stand, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stand> actualizarStand(@PathVariable Long id, Stand stand) {
        try {
            Stand standActualizado = standService.findById(id);
            standActualizado.setId(null);
            standActualizado.setNombre(stand.getNombre());
            standActualizado.setTipo(stand.getTipo());
            standActualizado.setHabilidad(stand.getHabilidad());

            standService.save(standActualizado);
            return new ResponseEntity<>(standActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarStand(@PathVariable Long id) {
        try {
            standService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
