package com.kreitek.kreitekfy.infraestructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Reproduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReproductionRepository extends JpaRepository<Reproduction, Long> {

    List<Reproduction> findAllBySong_id(Long songId);
}
