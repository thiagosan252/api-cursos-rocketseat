package br.com.rocketseat.app.cursos.modules.cursos.use_cases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketseat.app.cursos.modules.cursos.CursosRepository;
import br.com.rocketseat.app.cursos.modules.cursos.entities.CursosEntity;

@Service
public class GetCursosUseCase {

    @Autowired
    private CursosRepository cursosRepository;

    public List<CursosEntity> getAll() {
        return this.cursosRepository.findAll();
    }
}
