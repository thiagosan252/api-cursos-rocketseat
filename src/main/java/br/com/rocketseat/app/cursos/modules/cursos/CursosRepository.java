package br.com.rocketseat.app.cursos.modules.cursos;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocketseat.app.cursos.modules.cursos.entities.CursosEntity;

public interface CursosRepository extends JpaRepository<CursosEntity, UUID> {
    Optional<CursosEntity> findByName(String name);
}
