package com.example.demo.repository;

import com.example.demo.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Integer> {
}
