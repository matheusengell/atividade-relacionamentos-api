package com.atividade.api.repository;

import com.atividade.api.model.Assento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssentoRepository extends JpaRepository<Assento,Long> {
}
