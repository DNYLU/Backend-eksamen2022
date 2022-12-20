package com.example.backendeksamen2022.repository;

import com.example.backendeksamen2022.model.Van;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VanRepository extends JpaRepository<Van, Long> {
    Iterable<Van> findVansByBrand(String brand);

}
