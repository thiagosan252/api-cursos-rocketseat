package br.com.rocketseat.app.cursos.modules.cursos.entities;

public enum StatusCurso {
    INACTIVE("0"), ACTIVE("1");

    private String status;

    StatusCurso(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}