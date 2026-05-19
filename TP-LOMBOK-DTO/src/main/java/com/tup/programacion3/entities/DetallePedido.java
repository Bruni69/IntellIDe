package com.tup.programacion3.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class DetallePedido extends Base{
    private int cantidad;
    private Double subtotal;

    // Relación con Producto (Muchos detalles apuntan a un producto)
    private Producto producto;
}
