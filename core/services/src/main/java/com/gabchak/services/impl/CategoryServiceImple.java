package com.gabchak.services.impl;

import com.gabchak.dto.CategoryDto;
import com.gabchak.dto.mappers.CategoryMapper;
import com.gabchak.models.Category;
import com.gabchak.repositories.CategoryRepository;
import com.gabchak.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImple implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImple(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Optional<CategoryDto> findById(Integer id) {
        return categoryRepository.findById(id).map(category -> categoryMapper.map(category, CategoryDto.class));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.mapAsList(categoryRepository.findAll(), CategoryDto.class);
    }

    @Override
    public CategoryDto insert(CategoryDto categoryDto) {
        Category category = categoryMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
