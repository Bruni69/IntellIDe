package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Pedido extends Base implements Calculable{
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;

    @Builder.Default
    @ToString.Exclude // Evita recursión infinita
    private List<DetallePedido> detalles = new ArrayList<>();

    @Override
    public void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(d -> d.getSubtotal())
                .sum();
    }
}
