package com.example.wormhole.repository;

import com.example.wormhole.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message,Long> {
        List<Message> findByMessage(String message);
}
