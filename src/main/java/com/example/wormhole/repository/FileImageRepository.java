package com.example.wormhole.repository;

import com.example.wormhole.domain.FileExamination;
import org.springframework.data.repository.CrudRepository;

public interface FileImageRepository extends CrudRepository<FileExamination,Long> {

}
