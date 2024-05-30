package br.com.rocketseat.app.cursos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessadeDTO {
    private String message;
    private String field;
}
