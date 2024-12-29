package com.luisec.conversor.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.luisec.conversor.calculos.Conversiones;
import com.luisec.conversor.exceptions.NumeroNegativoException;
import com.luisec.conversor.monedas.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Moneda> monedas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String url = "https://v6.exchangerate-api.com/v6/7b85d52df169f933df807a95/latest/USD";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        String json = response.body();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        for(String nombre : conversionRates.keySet()){
            double value = conversionRates.get(nombre).getAsDouble();
            Moneda moneda = new Moneda(nombre,value);
            monedas.add(moneda);
        }

        while(true) {
            Panel.panelPrincipal();
            int opcion = sc.nextInt();
            if (opcion == 7) break;
            Panel.panelOperacion();
            try {
                double cantidad = sc.nextDouble();
                if (cantidad < 0) {
                    throw new NumeroNegativoException("No se puede usar números negativos");
                }
                double newValue = 0;
                String nombre = "";
                if (opcion == 1) {
                    newValue = Conversiones.dolarAMoneda(monedas, cantidad, "PEN");
                    nombre = "soles";
                } else if (opcion == 2) {
                    newValue = Conversiones.monedaADolar(monedas, cantidad, "PEN");
                    nombre = "dólares";
                } else if (opcion == 3) {
                    newValue = Conversiones.dolarAMoneda(monedas, cantidad, "ARS");
                    nombre = "pesos argentinos";
                } else if (opcion == 4) {
                    newValue = Conversiones.monedaADolar(monedas, cantidad, "ARS");
                    nombre = "dólares";
                } else if (opcion == 5) {
                    newValue = Conversiones.dolarAMoneda(monedas, cantidad, "CLP");
                    nombre = "pesos chilenos";
                } else if (opcion == 6) {
                    newValue = Conversiones.monedaADolar(monedas, cantidad, "CLP");
                    nombre = "dólares";
                }
                System.out.println("Valor convertido: " + (Math.round(newValue * 100) / (double) 100) + " " + nombre);
            }catch (NumeroNegativoException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
