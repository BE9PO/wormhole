package com.example.wormhole.repository;

import com.example.wormhole.domain.Examination;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExaminationRepository extends CrudRepository<Examination,Long> {
}
