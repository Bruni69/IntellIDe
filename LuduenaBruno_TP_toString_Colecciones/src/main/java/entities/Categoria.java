package entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Categoria extends Base {
    private String  nombre;
    private  String descripcion;
    private Set<Producto> productos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Long id, boolean eliminado, LocalDateTime creadtedAt, String nombre, String descripcion) {
        super(id, eliminado, creadtedAt);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
    public void addProducto(Producto p) {
        this.productos.add(p);
        }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + getId() + // Agregamos el ID para verlo en consola
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria that = (Categoria) o; // <-- CAMBIADO: Debe decir Categoria
        return java.util.Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }

}
