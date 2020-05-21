package com.gabchak.services;

import com.gabchak.dto.RecordDto;

import java.util.List;
import java.util.Optional;

public interface RecordService {

    Optional<RecordDto> findById(Integer id);

    List<RecordDto> findAll();

    RecordDto insert(RecordDto recordDto);

    void deleteById(Integer id);
}
