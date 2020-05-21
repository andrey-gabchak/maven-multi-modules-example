package com.gabchak.services.impl;

import com.gabchak.dto.RecordDto;
import com.gabchak.dto.mappers.RecordMapper;
import com.gabchak.models.Record;
import com.gabchak.repositories.RecordRepository;
import com.gabchak.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository, RecordMapper recordMapper) {
        this.recordRepository = recordRepository;
        this.recordMapper = recordMapper;
    }

    @Override
    public Optional<RecordDto> findById(Integer id) {
        return recordRepository.findById(id)
                .map(record -> recordMapper.map(record, RecordDto.class));
    }

    @Override
    public List<RecordDto> findAll() {
        return recordMapper.mapAsList(recordRepository.findAll(), RecordDto.class);
    }

    @Override
    public RecordDto insert(RecordDto recordDto) {
        Record record = recordMapper.map(recordDto, Record.class);
        Record savedRecord = recordRepository.save(record);
        return recordMapper.map(savedRecord, RecordDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        recordRepository.deleteById(id);
    }
}
