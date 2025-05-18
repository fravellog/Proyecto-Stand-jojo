package com.stand_vm.cl.stand_vm.controller;

import com.stand_vm.cl.stand_vm.model.Stand;
import com.stand_vm.cl.stand_vm.service.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
