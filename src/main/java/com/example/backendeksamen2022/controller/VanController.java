package com.example.backendeksamen2022.controller;

import com.example.backendeksamen2022.model.Van;
import com.example.backendeksamen2022.repository.VanRepository;
import com.example.backendeksamen2022.service.VanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/van")
public class VanController {
    private final VanService vanService;

    private final VanRepository vanRepository;

    public VanController(VanService vanService, VanRepository vanRepository) {
        this.vanService = vanService;
        this.vanRepository = vanRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Van>> getAllVans() {
     Iterable<Van> foundVans = vanService.getAllVans();
     return new ResponseEntity<>(foundVans, HttpStatus.OK);
    }
}
