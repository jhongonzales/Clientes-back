package com.company.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private String mensaje;
    private String detalles;
    private LocalDateTime fecha;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String mensaje, String detalles, LocalDateTime fecha) {
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
