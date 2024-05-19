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
@ToString
public class AlumnoModel implements Serializable {
    @Id
    @NonNull
    @Positive
    int id;

    @NonNull
    @NotBlank
    @NotEmpty
    String nombre;

    @NonNull
    @NotBlank
    @NotEmpty
    String apellido;

    @NonNull
    @NotBlank
    @NotEmpty
    String estado;

    @NonNull
    @Positive
    int edad;
}
