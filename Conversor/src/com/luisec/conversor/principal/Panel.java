package com.luisec.conversor.principal;

public class Panel {
    public static void panelPrincipal(){
        System.out.println("""
                ##########################################
                Sea bienvenido al Conversor de Moneda =]
                1) Dólar =>> Sol Peruano
                2) Sol Peruano ==> Dólar
                3) Dólar =>> Peso Argentino
                4) Peso Argentino =>> Dólar
                5) Dólar =>> Peso Chileno
                6) Peso Chileno =>> Dólar
                7) Salir
                ##########################################
                """);
        System.out.print("Escriba su opción: ");
    }

    public static void panelOperacion(){
        System.out.print("Ingrese la cantidad a convertir: ");
    }
}
