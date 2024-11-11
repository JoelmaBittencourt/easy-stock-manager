package com.jibs.easy_stock_manager.infrastructure.adapter.mapper;


import com.jibs.easy_stock_manager.domain.model.ProductModel;
import com.jibs.easy_stock_manager.infrastructure.adapter.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDataGatewayMapper {

    ProductModel toModel(ProductEntity entity);

    @Mapping(target = "id", ignore = true)
    ProductEntity toEntity(ProductModel model);
}
