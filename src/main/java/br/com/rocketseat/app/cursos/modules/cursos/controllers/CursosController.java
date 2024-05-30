package br.com.rocketseat.app.cursos.modules.cursos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketseat.app.cursos.modules.cursos.dto.CursosUpdateDTO;
import br.com.rocketseat.app.cursos.modules.cursos.entities.CursosEntity;
import br.com.rocketseat.app.cursos.modules.cursos.entities.StatusCurso;
import br.com.rocketseat.app.cursos.modules.cursos.use_cases.CreateCursosUseCase;
import br.com.rocketseat.app.cursos.modules.cursos.use_cases.DeleteCursosUseCase;
import br.com.rocketseat.app.cursos.modules.cursos.use_cases.GetCursosUseCase;
import br.com.rocketseat.app.cursos.modules.cursos.use_cases.UpdateCursosUseCase;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/cursos")
public class CursosController {

    @Autowired
    CreateCursosUseCase createCursosUseCase;

    @Autowired
    UpdateCursosUseCase updateCursosUseCase;

    @Autowired
    GetCursosUseCase getCursosUseCase;

    @Autowired
    DeleteCursosUseCase deleteCursosUseCase;

    @GetMapping("")
    public List<CursosEntity> get() {
        return getCursosUseCase.getAll();
    }

    @PostMapping("")
    public CursosEntity create(@Valid @RequestBody CursosEntity cursosEntity) {
        return createCursosUseCase.execute(cursosEntity);
    }

    @PutMapping("/{id}")
    public CursosEntity update(@Valid @RequestBody CursosUpdateDTO cursosUpdateDTO,
            @PathVariable(name = "id", required = true) String id) {
        return updateCursosUseCase.execute(cursosUpdateDTO, UUID.fromString(id));
    }

    @PatchMapping("/{id}/active")
    public CursosEntity patch(@PathVariable(name = "id", required = true) String id) {
        return updateCursosUseCase.changeStatusCurso(StatusCurso.ACTIVE, UUID.fromString(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        deleteCursosUseCase.execute(UUID.fromString(id));
    }

}
