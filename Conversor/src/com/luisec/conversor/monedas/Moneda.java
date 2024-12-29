package com.luisec.conversor.monedas;

public class Moneda {
    private double value;
    private String name;

    public Moneda() {

    }

    public Moneda(String name,double value){
        this.name = name;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
