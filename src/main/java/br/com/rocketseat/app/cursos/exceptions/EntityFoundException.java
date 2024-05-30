package br.com.rocketseat.app.cursos.exceptions;

public class EntityFoundException extends RuntimeException {
    public EntityFoundException(String message) {
        super(message);
    }
}
