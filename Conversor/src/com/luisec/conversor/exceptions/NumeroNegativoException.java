package com.luisec.conversor.exceptions;

public class NumeroNegativoException extends RuntimeException{
    String mensaje;
    public NumeroNegativoException(String mensaje){
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
