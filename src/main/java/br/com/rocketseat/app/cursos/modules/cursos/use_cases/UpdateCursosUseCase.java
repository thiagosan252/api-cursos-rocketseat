package br.com.rocketseat.app.cursos.modules.cursos.use_cases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketseat.app.cursos.exceptions.EntityFoundException;
import br.com.rocketseat.app.cursos.modules.cursos.CursosRepository;
import br.com.rocketseat.app.cursos.modules.cursos.dto.CursosUpdateDTO;
import br.com.rocketseat.app.cursos.modules.cursos.entities.CursosEntity;
import br.com.rocketseat.app.cursos.modules.cursos.entities.StatusCurso;

@Service
public class UpdateCursosUseCase {

        @Autowired
        private CursosRepository cursosRepository;

        public CursosEntity execute(CursosUpdateDTO cursosUpdateDTO, UUID id) {
                CursosEntity cursosEntityDB = this.cursosRepository.findById(id)
                                .orElseThrow(() -> new EntityFoundException("Curso não encontrado"));

                CursosEntity cursosEntityNew = CursosEntity.builder()
                                .id(cursosEntityDB.getId())
                                .createdAt(cursosEntityDB.getCreatedAt())
                                .name(cursosUpdateDTO.name() != null ? cursosUpdateDTO.name()
                                                : cursosEntityDB.getName())
                                .category(cursosUpdateDTO.category() != null ? cursosUpdateDTO.category()
                                                : cursosEntityDB.getCategory())
                                .active(cursosEntityDB.getActive())
                                .build();

                return this.cursosRepository.save(cursosEntityNew);
        }

        public CursosEntity changeStatusCurso(StatusCurso statusCurso, UUID id) {
                CursosEntity cursosEntity = this.cursosRepository.findById(id)
                                .orElseThrow(() -> new EntityFoundException("Curso não encontrado"));

                if (cursosEntity.getActive().equals(StatusCurso.ACTIVE)) {
                        throw new EntityFoundException("Curso já está ativo");
                }

                cursosEntity.setActive(statusCurso);
                return this.cursosRepository.save(cursosEntity);
        }

}
