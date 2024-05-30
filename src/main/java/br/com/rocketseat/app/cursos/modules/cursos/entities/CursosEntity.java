package br.com.rocketseat.app.cursos.modules.cursos.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "tb_cursos")
@AllArgsConstructor
@NoArgsConstructor
public class CursosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid_id")
    private UUID id;

    @Column(name = "vc_name")
    @NotBlank(message = "O campo [name] não pode ser em branco/vazio/nulo")
    private String name;

    @Column(name = "vc_category")
    @NotBlank(message = "O campo [category] não pode ser em branco/vazio/nulo")
    private String category;

    @Column(name = "ni_active", columnDefinition = "smallint default 0")
    @Enumerated(EnumType.ORDINAL)
    private StatusCurso active = StatusCurso.INACTIVE;

    @Column(name = "dt_created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
