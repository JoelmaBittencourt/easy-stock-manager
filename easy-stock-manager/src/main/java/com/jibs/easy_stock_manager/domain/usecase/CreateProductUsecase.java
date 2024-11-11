package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.model.ProductModel;

public interface CreateProductUsecase {

    ProductModel usecase(ProductModel productModel);
}
