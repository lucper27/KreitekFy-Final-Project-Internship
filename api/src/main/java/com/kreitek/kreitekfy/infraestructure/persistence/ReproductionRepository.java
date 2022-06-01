package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Reproduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReproductionRepository extends JpaRepository<Reproduction, Long> {
}
