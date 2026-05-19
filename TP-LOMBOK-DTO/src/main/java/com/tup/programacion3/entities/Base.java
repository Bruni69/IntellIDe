package com.tup.programacion3.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public abstract class Base implements Serializable  {
    protected Long id;

    @Builder.Default
    protected boolean eliminado = false;

    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();

}
