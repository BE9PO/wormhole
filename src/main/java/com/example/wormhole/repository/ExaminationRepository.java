package com.example.wormhole.repository;

import com.example.wormhole.domain.Examination;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExaminationRepository extends CrudRepository<Examination,Long> {


    Iterable<Examination> findAllByDateInput (LocalDate dateInput);

    Iterable<Examination> findAllByCode (String code);

    Iterable<Examination> findAllByCodeOrDateInputOrDateOutput(String code, LocalDate dateInput, LocalDate dateOutput);

    Iterable<Examination> findAllByDateOutput (LocalDate dateOutput);

    Iterable<Examination> findAllByCodeAndDateInput (String code, LocalDate dateInput);

    Iterable<Examination> findAllByCodeAndDateOutput (String code, LocalDate dateOutput);

    Iterable<Examination> findAllByDateInputAndDateOutput (LocalDate dateInput, LocalDate dateOutput);



}
