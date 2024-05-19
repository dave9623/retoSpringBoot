package org.retosb.retoencorasb.service;

import lombok.extern.slf4j.Slf4j;
import org.retosb.retoencorasb.dto.AlumnoReqDto;
import org.retosb.retoencorasb.model.AlumnoModel;
import org.retosb.retoencorasb.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@Slf4j
public class AlumnoServiceImpl implements AlumnoService{
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Mono<AlumnoModel> save(AlumnoReqDto request) {
        log.info("INICIO PROCESO ==> REGISTRO ALUMNO");
        //Se consulta si existe registro con id del request
        Optional<AlumnoModel> alumno = alumnoRepository.findById(request.getId());

        //Si existe se devuelve mensaje de error
        if (alumno.isPresent()) {
            log.error(MessageFormat.format("ALUMNO CON ID [{0}] YA SE ENCUENTRA REGISTRADO",request.getId()));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MessageFormat.format("ID [{0}] ya se encuentra registrado", request.getId()));
        }

        log.info(MessageFormat.format("SE REGISTRA ALUMNO CON ID [{0}]",request.getId()));
        return Mono.just(alumnoRepository.save(AlumnoModel.builder()
                .id(request.getId())
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .estado(request.getEstado())
                .edad(request.getEdad())
                .build()));
    }

    @Override
    public Flux<AlumnoModel> getAll() {
        log.info("INICIO PROCESO ==> OBTENER ALUMNOS CON ESTADO ACTIVO [1]");
        return Mono.just(alumnoRepository.findAllActive()).flatMapIterable(t -> t).log();
    }
}