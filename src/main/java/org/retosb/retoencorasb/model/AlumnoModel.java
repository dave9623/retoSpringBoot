package org.retosb.retoencorasb.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AlumnoModel implements Serializable {
    @Id
    @Positive
    int id;

    @NotBlank
    String nombre;

    @NotBlank
    String apellido;

    @NotBlank
    String estado;

    @Positive
    int edad;
}
