package org.retosb.retoencorasb.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class AlumnoReqDto implements Serializable {

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
