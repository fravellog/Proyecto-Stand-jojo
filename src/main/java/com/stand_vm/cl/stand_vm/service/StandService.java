package com.stand_vm.cl.stand_vm.service;

import com.stand_vm.cl.stand_vm.model.Stand;
import com.stand_vm.cl.stand_vm.repository.StandRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StandService {
    @Autowired
    private StandRepository standRepository;

    public List<Stand> findAll() {
        return standRepository.findAll();
    }

    public Stand findById(Long id) {
        return standRepository.findById(id).get();
    }

    public Stand save(Stand stand) {
        return standRepository.save(stand);
    }

    public void deleteById(Long id) {
        standRepository.deleteById(id);
    }

}
