package com.victhor.pcanina.repositories;

import com.victhor.pcanina.entities.Adoptante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdoptanteRepository extends JpaRepository<Adoptante, Integer> {
    @Query("SELECT a FROM Adoptante a WHERE a.dni=:dni AND a.nombre=:nombre")
    public List<Adoptante> findByDniAndNombre(@Param("dni") String dni, @Param("nombre") String nombre);
    public List<Adoptante> findByNombre(String nombre);
    public List<Adoptante> findByDni(String dni);
    public Adoptante findAllById(Integer id);
}
