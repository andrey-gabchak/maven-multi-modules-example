package com.gabchak.repositories;

import com.gabchak.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}
