package org.retosb.retoencorasb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.retosb.retoencorasb.dto.AlumnoReqDto;
import org.retosb.retoencorasb.model.AlumnoModel;
import org.retosb.retoencorasb.repository.AlumnoRepository;
import org.retosb.retoencorasb.service.AlumnoServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

@SpringBootTest
class RetoEncoraSbApplicationTests {

    @InjectMocks
    AlumnoServiceImpl service;

    @Mock
    AlumnoRepository alumnoRepository;

    AlumnoModel model = new AlumnoModel();

    AlumnoReqDto request;
    String caseKey;

    private static final Map<String, AlumnoReqDto> EVENTOS_MAP = Map.of(
            "SaveCaso1", new AlumnoReqDto(),
            "SaveCaso2", new AlumnoReqDto()
    );

    private static Stream<Map.Entry<String, AlumnoReqDto>> provideCase() {
        return EVENTOS_MAP.entrySet().stream();
    }

    private static final Map<String, Supplier<AlumnoModel>> caseActions = new HashMap<>();


    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);

        caseActions.put("SaveCaso1", () -> {
            Mockito.when(alumnoRepository.findById(Mockito.anyInt()))
                    .thenReturn(Optional.of(model));
            return null;
        });

        caseActions.put("SaveCaso2", () -> {
            Mockito.when(alumnoRepository.save(Mockito.any()))
                    .thenReturn(model);
            return null;
        });

    }

    @ParameterizedTest
    @MethodSource("provideCase")
    void saveTest(Map.Entry<String, AlumnoReqDto> caseEntry){
        request = caseEntry.getValue();
        caseKey = caseEntry.getKey();
        request.setId(1);
        request.setNombre("a");
        request.setApellido("a");
        request.setEstado("1");
        request.setEdad(15);

        caseActions.get(caseKey).get();

        try {
            service.save(request);
        } catch (Exception ignored){
        }
    }

    @Test
    void getAllTest(){
        Mockito.when(alumnoRepository.findAllActive())
                .thenReturn(Arrays.asList(model, model));

        service.getAll();
    }
}
