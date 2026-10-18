package com.casosofia.asistente.repository;

import com.casosofia.asistente.model.Pictograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PictogramaRepository extends JpaRepository<Pictograma, Long> {

    List<Pictograma> findByTema(String tema);

    Optional<Pictograma> findByClave(String clave);
}
