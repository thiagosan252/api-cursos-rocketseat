package br.com.rocketseat.app.cursos.modules.cursos.use_cases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketseat.app.cursos.modules.cursos.CursosRepository;

@Service
public class DeleteCursosUseCase {
    @Autowired
    private CursosRepository cursosRepository;

    public void execute(UUID id) {
        this.cursosRepository.deleteById(id);
    }

}
