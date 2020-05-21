package com.gabchak.dto.mappers;

import com.gabchak.dto.CategoryDto;
import com.gabchak.models.Category;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Category.class, CategoryDto.class)
                .exclude("records")
                .customize(new CustomMapper<Category, CategoryDto>() {
                    @Override
                    public void mapAtoB(Category category, CategoryDto categoryDto, MappingContext context) {
                        super.mapAtoB(category, categoryDto, context);
                    }

                    @Override
                    public void mapBtoA(CategoryDto categoryDto, Category category, MappingContext context) {
                        super.mapBtoA(categoryDto, category, context);
                    }
                })
                .byDefault()
                .register();
    }
}
