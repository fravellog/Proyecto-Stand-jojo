package com.stand_vm.cl.stand_vm.repository;

import com.stand_vm.cl.stand_vm.model.Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends JpaRepository<Stand, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre:
    // List<Stand> findByNombre(String nombre);

}
