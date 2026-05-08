package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Base {
    protected Long id;
    protected boolean eliminado;
    protected LocalDateTime creadtedAt;

    public Base(){}

    public Base(Long id, boolean eliminado, LocalDateTime creadtedAt) {
        this.id = id;
        this.eliminado = eliminado;
        this.creadtedAt = creadtedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreadtedAt() {
        return creadtedAt;
    }

    public void setCreadtedAt(LocalDateTime creadtedAt) {
        this.creadtedAt = creadtedAt;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", eliminado=" + eliminado +
                ", createdAt=" + creadtedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Paso extra de seguridad: ¿Son el mismo espacio de memoria?
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Objects.equals(id, base.id); // Solo comparamos el ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Solo el hash del ID
    }
}

