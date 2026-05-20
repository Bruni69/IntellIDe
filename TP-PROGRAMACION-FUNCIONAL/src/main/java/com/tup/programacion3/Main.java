package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- Datos de prueba ---
        List<Producto> productos = new ArrayList<>();
        productos.add(Producto.builder().id(1L).nombre("Pizza").precio(1500.0).stock(10).disponible(true).build());
        productos.add(Producto.builder().id(2L).nombre("Hamburguesa").precio(2000.0).stock(3).disponible(true).build());
        productos.add(Producto.builder().id(3L).nombre("Coca cola").precio(500.0).stock(0).disponible(false).build());
        productos.add(Producto.builder().id(4L).nombre("Pancho").precio(800.0).stock(4).disponible(true).build());
        productos.add(Producto.builder().id(5L).nombre("Agua").precio(500.0).stock(10).disponible(true).build());

        //muestro los productos
        System.out.println("--- PRODUCTOS DISPONIBLES ---");
        productos.stream()
                .filter(p -> p.getDisponible() != null && p.getDisponible()) // Evita NullPointerException
                .forEach(p -> System.out.println(p.getNombre() + " - Precio: $" + p.getPrecio()));

        //creo un pedido
        Pedido ped1= Pedido.builder()
                .id(001L)
                .fecha(LocalDate.now())
                .estado(Estado.PENDIENTE)
                .formaPago(FormaPago.EFECTIVO)
                .build();
        // sus dos detalles del pedido
        DetallePedido det1= DetallePedido.builder()
                .id(1L)
                .cantidad(2)
                .producto(productos.get(0))
                .subtotal(productos.get(0).getPrecio()*2)
                .build();
        DetallePedido det2 = DetallePedido.builder()
                .id(5L)
                .cantidad(3)
                .producto(productos.get(4))
                .subtotal(productos.get(4).getPrecio()*3)
                .build();
        ped1.getDetalles().add(det1);
        ped1.getDetalles().add(det2);

        // Punto 1 - Calcular total del pedido
        ped1.calcularTotal();
        System.out.println("\n--- TOTAL DEL PEDIDO ---");
        System.out.println("Pedido " + ped1.getId() + " - Total: $" + ped1.getTotal());

        //aqui sumo la cantidad de pedidos
        int totalItems = ped1.getDetalles().stream()
                .mapToInt(DetallePedido::getCantidad)
                .sum();

        System.out.println("\n ---ITEM DEL PEDIDO---");
        System.out.println("Pedido "+ped1.getId() + " Total de items: "+totalItems);

        //calculo el stock menor a 5
        System.out.println("\n---Productos con stock menor a 5:---");
        productos.stream()
                .filter(p->p.getStock()<5)
                .forEach(producto -> System.out.println(producto.getNombre() +"- Stock: "+ producto.getStock()));

    }
}