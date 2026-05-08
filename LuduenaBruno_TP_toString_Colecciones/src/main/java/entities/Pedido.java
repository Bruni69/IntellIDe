package entities;

import com.tup.programacion3.Calculable;
import enums.Estado;
import enums.FormaPago;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Pedido extends Base implements Calculable {
    private Set<DetallePedido> detalles = new HashSet<>();
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Usuario usuario;                   //el dueño del pedido

    public Pedido() {
    }

    public Pedido(Long id, boolean eliminado, LocalDateTime creadtedAt, LocalDate fecha, Estado estado, Double total, FormaPago formaPago, Usuario usuario) {
        super(id, eliminado, creadtedAt);
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formaPago = formaPago;
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void addDetallePedido(DetallePedido detalle) {
        this.detalles.add(detalle);
    }
    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detalleEncontrado = findDetallePedidoByProducto(producto);
        if (detalleEncontrado != null) {
            detalles.remove(detalleEncontrado);
            System.out.println("Detalle eliminado.");
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", creadtedAt=" + creadtedAt +
                ", eliminado=" + eliminado +
                ", formaPago=" + formaPago +
                ", total=" + total +
                ", estado=" + estado +
                '}';
    }

    @Override
    public void calcularTotal() {
        double acumulador = 0.0;
        // Recorremos la colección Set de detalles
        for (DetallePedido detalle : detalles) {
            if (detalle.getSubtotal() != null) {
                acumulador += detalle.getSubtotal();
            }
        }
        this.total = acumulador; // Guardamos el resultado en el atributo total
        System.out.println("El total calculado para el pedido es: " + this.total);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return java.util.Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }
}
