package org.retosb.retoencorasb.controller;

import lombok.extern.slf4j.Slf4j;
import org.retosb.retoencorasb.dto.AlumnoReqDto;
import org.retosb.retoencorasb.model.AlumnoModel;
import org.retosb.retoencorasb.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/alumno/")
@Slf4j
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PutMapping("/save")
    private Mono<AlumnoModel> saveAlumno (@RequestBody  @Valid AlumnoReqDto request){
        return alumnoService.save(request);
    }

    @GetMapping("/get")
    private Flux<AlumnoModel> getAllActive (){
        return alumnoService.getAll();
    }

}
