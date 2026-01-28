package com.victhor.pcanina.repositories;

import com.victhor.pcanina.common.EstadoPerro;
import com.victhor.pcanina.entities.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerroRepository extends JpaRepository<Perro, Integer> {
    public List<Perro> findByNombre(@Param("nombre") String nombre);
    public List<Perro> findByEstado(@Param("estado") EstadoPerro estado);
    @Query("SELECT p from Perro p WHERE p.nombre=:nombre AND p.estado=:estado")
    public List<Perro> findByNombreYEstado(@Param("nombre") String nombre,@Param("estado") EstadoPerro estado);
}
