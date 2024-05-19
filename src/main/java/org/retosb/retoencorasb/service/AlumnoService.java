package org.retosb.retoencorasb.service;

import org.retosb.retoencorasb.dto.AlumnoReqDto;
import org.retosb.retoencorasb.model.AlumnoModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {
    Mono<AlumnoModel> save (AlumnoReqDto request);
    Flux<AlumnoModel> getAll ();
}
