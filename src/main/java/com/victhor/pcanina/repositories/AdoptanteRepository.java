package com.victhor.pcanina.repositories;

import com.victhor.pcanina.entities.Adoptante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdoptanteRepository extends JpaRepository<Adoptante, Integer> {

    public Optional<Adoptante> findByNombre(String nombre);

}
