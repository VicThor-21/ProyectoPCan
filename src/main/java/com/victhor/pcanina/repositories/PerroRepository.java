package com.victhor.pcanina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.entities.Perro;

public interface PerroRepository extends JpaRepository<Perro, Integer> {
    public List<Perro> findByNombre(@Param("nombre") String nombre);
    public List<Perro> findByEstado(@Param("estado") EstadoPerro estado);
    @Query("SELECT p from Perro p WHERE p.nombre=:nombre AND p.estado=:estado")
    public List<Perro> findByNombreYEstado(@Param("nombre") String nombre,@Param("estado") EstadoPerro estado);
}
