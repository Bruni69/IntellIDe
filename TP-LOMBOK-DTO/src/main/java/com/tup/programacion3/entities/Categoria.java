package com.tup.programacion3.entities;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Categoria extends Base{
    private String nombre;
    private String descripcion;

    @Builder.Default
    @ToString.Exclude // Evita el ciclo infinito con Producto
    private List<Producto> productos = new ArrayList<>();
}
