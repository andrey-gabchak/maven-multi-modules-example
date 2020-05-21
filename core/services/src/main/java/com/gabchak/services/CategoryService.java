package com.gabchak.services;

import com.gabchak.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<CategoryDto> findById(Integer id);

    List<CategoryDto> findAll();

    CategoryDto insert(CategoryDto categoryDto);

    void deleteById(Integer id);
}
