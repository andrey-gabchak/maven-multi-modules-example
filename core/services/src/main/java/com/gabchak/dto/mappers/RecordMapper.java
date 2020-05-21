package com.gabchak.dto.mappers;

import com.gabchak.dto.CategoryDto;
import com.gabchak.dto.RecordDto;
import com.gabchak.models.Category;
import com.gabchak.models.Record;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordMapper extends ConfigurableMapper {

    private final CategoryMapper categoryMapper;

    @Autowired
    public RecordMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Record.class, RecordDto.class)
                .exclude("category")
                .customize(new CustomMapper<Record, RecordDto>() {
                    @Override
                    public void mapAtoB(Record record, RecordDto recordDto, MappingContext context) {
                        super.mapAtoB(record, recordDto, context);
                        CategoryDto categoryDto = categoryMapper.map(record.getCategory(), CategoryDto.class);
                        recordDto.setCategory(categoryDto);
                    }

                    @Override
                    public void mapBtoA(RecordDto recordDto, Record record, MappingContext context) {
                        super.mapBtoA(recordDto, record, context);
                        Category category = categoryMapper.map(recordDto.getCategory(), Category.class);
                        record.setCategory(category);
                    }
                })
                .byDefault()
                .register();
    }
}
