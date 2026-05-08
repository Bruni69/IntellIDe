package com.tup.programacion3;

import entities.*;
import enums.Estado;
import enums.FormaPago;
import enums.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime ahora = LocalDateTime.now(); //DECLARO ESTA VARIABLE PARA QUE NO MARQUE ERROR Y RECONOZCA UNA FECHA
        LocalDate fechaHoy = LocalDate.now();
        //3.c
        Categoria catPizzas = new Categoria(1L, false, ahora, "Pizzas", "Tradicionales al horno");
        Categoria catBebidas = new Categoria(2L, false, ahora, "Bebidas", "Frías y calientes");
        Categoria catPostres = new Categoria(3L, false, ahora, "Postres", "Caseros");

        //10 productos 3.d
        Producto p1_pizza = new Producto(1L, false, ahora, "Muzzarella", 5000.0, "Pizza", 10, "url", true);
        Producto p2_faina = new Producto(2L, false, ahora, "Fainá", 1000.0, "Porción", 20, "url", true);
        Producto p3_bebida = new Producto(3L, false, ahora, "Coca Cola", 500.0, "Unidad", 100, "url", true);
        Producto p4_bebida = new Producto(4L, false, ahora, "Agua", 500.0, "Unidad", 100, "url", true);
        Producto p5_bebida = new Producto(5L, false, ahora, "vaso tinto/blanco", 5000.0, "Unidad", 20, "url", false);
        Producto p6_postre = new Producto(6L, false, ahora, "Budin de pan", 2500.0, "Porcion", 20, "url", true);
        Producto p7_pizza = new Producto(7L, false, ahora, "Fugazzeta", 4500.0, "Pizza", 20, "url", true);
        Producto p8_pizza = new Producto(8L, false, ahora, "Margarita", 7000.0, "Pizza", 10, "url", true);
        Producto p9_extra= new Producto(9L, false, ahora, "doble queso", 1000.0, "extra de queso", 20, "url", true);
        Producto p10_bebida = new Producto(10L, false, ahora, "Cerveza", 1500.0, "Unidad 1Lts", 100, "url", true);

        // 3 categorias 3.c
        //se vincula productos a categorias
        catPizzas.addProducto(p1_pizza);
        catPizzas.addProducto(p7_pizza);
        catBebidas.addProducto(p3_bebida);
        catPostres.addProducto(p6_postre);

        //2 usuarios 3.a
        Usuario u1= new Usuario(1L,false,ahora, "Bruno",Rol.USER,"admin123","15669724","bruno@gmail.com","Ludueña");
        Usuario u2= new Usuario(2L,true,ahora, "Elizabeth",Rol.USER,"admin456","15664985","eli@gmail.com","Acosta");

        //3 pedidos y dos detalles  3.b
        Pedido p1_muzzarella= new Pedido(1L,false,ahora,fechaHoy, Estado.PENDIENTE,18599.35, FormaPago.TRANSFERENCIA,u2);
        Pedido p2= new Pedido(2L,false,ahora,fechaHoy, Estado.CONFIRMADO,8599.33, FormaPago.TARJETA,u2);
        Pedido p3= new Pedido(3L,false,ahora,fechaHoy, Estado.CANCELADO,618599.00, FormaPago.EFECTIVO,u1);

        DetallePedido det1 = new DetallePedido(1L, false, ahora, 2, 10000.0, p1_pizza);
        DetallePedido det2 = new DetallePedido(10L, false, ahora, 2, 3000.0, p10_bebida);
        DetallePedido det3 = new DetallePedido(3L, false, ahora, 1, 5000.0, p5_bebida);
        DetallePedido det4 = new DetallePedido(4L, false, ahora, 2, 5000.0, p6_postre);
        p2.addDetallePedido(det3);
        p2.addDetallePedido(det4);
        p2.calcularTotal();

        DetallePedido det5 = new DetallePedido(5L, false, ahora, 1, 7000.0, p8_pizza);
        DetallePedido det6 = new DetallePedido(6L, false, ahora, 1, 1000.0, p9_extra);
        p3.addDetallePedido(det5);
        p3.addDetallePedido(det6);
        p3.calcularTotal();

        // Agregar los detalles al Pedido 1
        p1_muzzarella.addDetallePedido(det1);
        p1_muzzarella.addDetallePedido(det2);

// Vincular los pedidos a los usuarios (según tu UML)
        u2.addPedido(p1_muzzarella);
        u2.addPedido(p2);
        u1.addPedido(p3);

// Calcular totales
        p1_muzzarella.calcularTotal();

        System.out.println("\n--- PUNTO 4: REPORTES ---");
// Mostrar un producto
        System.out.println("Un producto: " + p1_pizza.toString());

// Mostrar el listado de productos (Podés meterlos en un Set o imprimirlos uno a uno)
        System.out.println(p1_pizza);
        System.out.println(p2_faina);
        System.out.println(p3_bebida);
        System.out.println(p4_bebida);
        System.out.println(p5_bebida);
        System.out.println(p6_postre);
        System.out.println(p7_pizza);
        System.out.println(p8_pizza);
        System.out.println(p9_extra);
        System.out.println(p10_bebida);

// Mostrar los pedidos del usuario con más pedidos
// Como u2 tiene el p1 y p2, y u1 solo el p3:
        System.out.println("Pedidos (Usuario con más pedidos):" +u2.getNombre());
        for (Pedido p : u2.getPedidos()) {
            System.out.println(p.toString());
        }
        System.out.println("\n--- PUNTO 5: PRUEBA DE IDENTIDAD ---");
        Producto pPrueba = new Producto(1L, false, ahora, "Muzzarella", 5000.0, "Pizza", 10, "url", true);
        System.out.println("¿Es pPrueba igual al p1_pizza original (mismo ID)?: " + pPrueba.equals(p1_pizza));

        // Si intentamos agregarlo a la categoría (que usa un Set), verás que no se duplica.
        catPizzas.addProducto(pPrueba);
        System.out.println("Cantidad de productos en Categoría Pizzas (debería seguir siendo 2): " + catPizzas.getProductos().size());
    }

}
