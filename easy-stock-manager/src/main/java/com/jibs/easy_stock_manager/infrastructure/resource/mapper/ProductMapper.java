package com.jibs.easy_stock_manager.infrastructure.resource.mapper;

import com.jibs.easy_stock_manager.domain.model.ProductModel;
import com.jibs.easy_stock_manager.infrastructure.resource.request.ProductRequest;
import com.jibs.easy_stock_manager.infrastructure.resource.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductModel toModel(ProductRequest request);

    ProductResponse toResponse(ProductModel model);
}
