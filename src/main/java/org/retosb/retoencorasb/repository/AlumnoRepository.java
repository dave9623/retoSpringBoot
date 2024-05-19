package org.retosb.retoencorasb.repository;

import org.retosb.retoencorasb.model.AlumnoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, Integer> {
    Optional<AlumnoModel> findById (int id);

    @Query(value="SELECT e FROM AlumnoModel e " +
            "WHERE e.estado='1' ")
    List<AlumnoModel> findAllActive ();
}
