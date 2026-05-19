package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // Instancia un producto para la prueba de equals (Punto 5)
            Producto p1 = Producto.builder().id(1L).nombre("Pizza").precio(1500.0).build();
            Producto p2 = Producto.builder().id(1L).nombre("Pizza").precio(1500.0).build();

            System.out.println("--- Prueba de Equals ---");
            // Lombok generó el equals que compara por el ID heredado de Base
            System.out.println("¿Son iguales? " + p1.equals(p2));

            System.out.println("\n--- ToString del Producto ---");
            System.out.println(p1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}