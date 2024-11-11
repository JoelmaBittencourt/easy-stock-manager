package com.jibs.easy_stock_manager.domain.gateway;

import com.jibs.easy_stock_manager.domain.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {

    ProductModel create(ProductModel product);

    Optional<ProductModel> getByName(String name);

    List<ProductModel> getAll();

    List<ProductModel> findByCategory(String category);

    List<ProductModel> findBySubCategory(String subCategory);

    ProductModel update(String name, ProductModel productModel);
}
