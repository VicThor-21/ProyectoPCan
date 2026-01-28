package com.victhor.pcanina.repositories;

import com.victhor.pcanina.entities.HistorialClinico;
import com.victhor.pcanina.entities.Perro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HCRepository extends JpaRepository<HistorialClinico, Integer> {

    public List<HistorialClinico> findByPerro(Perro perro);
}
