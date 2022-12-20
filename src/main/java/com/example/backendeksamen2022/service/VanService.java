package com.example.backendeksamen2022.service;

import com.example.backendeksamen2022.model.Van;
import com.example.backendeksamen2022.repository.VanRepository;
import org.springframework.stereotype.Service;

@Service
public class VanService {
VanRepository vanRepository;

    public VanService(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
    }

    public Iterable<Van> getAllVans() {
        return vanRepository.findAll();
    }
}
