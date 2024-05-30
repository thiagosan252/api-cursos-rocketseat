package br.com.rocketseat.app.cursos.modules.cursos.use_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketseat.app.cursos.exceptions.EntityFoundException;
import br.com.rocketseat.app.cursos.modules.cursos.CursosRepository;
import br.com.rocketseat.app.cursos.modules.cursos.entities.CursosEntity;

@Service
public class CreateCursosUseCase {

    @Autowired
    private CursosRepository cursosRepository;

    public CursosEntity execute(CursosEntity companyEntity) {
        this.cursosRepository.findByName(companyEntity.getName())
                .ifPresent(user -> {
                    throw new EntityFoundException("Curso já existe");
                });

        return this.cursosRepository.save(companyEntity);

    }
}
