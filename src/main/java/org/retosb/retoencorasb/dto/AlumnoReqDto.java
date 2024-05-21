package org.retosb.retoencorasb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class AlumnoReqDto implements Serializable {

    @NotNull (message = "El campo 'id' no debe ser nulo")
    @Positive (message = "El campo 'id' debe ser positivo y mayor que cero")
    private int id;

    @NotBlank (message = "El campo 'nombre' no debe ser nulo o vacío")
    @Size (min = 2, max = 20, message = "El campo 'nombre' debe contener entre 2 y 20 caracteres")
    private String nombre;

    @NotBlank (message = "El campo 'apellido' no debe ser nulo o vacío")
    @Size (min = 2, max = 20, message = "El campo 'apellido' debe contener dentre 2 y 20 caracteres")
    private String apellido;

    @NotBlank (message = "El campo 'estado' no debe ser nulo o vacío")
    @Size (min = 1, max = 1, message = "El campo 'estado' no debe exceder de un caracter")
    private String estado;

    @NotNull (message = "El campo 'edad' no debe ser nulo")
    @Positive (message = "El campo 'edad' debe ser positivo y mayor que cero")
    private int edad;
}
