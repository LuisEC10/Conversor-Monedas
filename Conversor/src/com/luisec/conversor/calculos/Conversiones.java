package com.luisec.conversor.calculos;

import com.luisec.conversor.monedas.Moneda;

import java.util.List;

public class Conversiones {
    public static double dolarAMoneda(List<Moneda> monedas,double cantidad,String mon){
        for(Moneda moneda : monedas){
            if(moneda.getName().equals(mon)){
                return cantidad * moneda.getValue();
            }
        }
        return 0.0;
    }

    public static double monedaADolar(List<Moneda> monedas,double cantidad,String mon){
        for(Moneda moneda : monedas){
            if(moneda.getName().equals(mon)){
                return cantidad / moneda.getValue();
            }
        }
        return 0.0;
    }
}

