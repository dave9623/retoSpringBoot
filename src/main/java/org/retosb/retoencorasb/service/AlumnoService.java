package org.retosb.retoencorasb.service;

import org.retosb.retoencorasb.model.AlumnoModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {
    Mono<AlumnoModel> save (AlumnoModel request);
    Flux<AlumnoModel> getAll ();
}
