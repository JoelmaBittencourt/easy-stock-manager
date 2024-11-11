package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.model.ProductModel;

import java.util.Optional;

public interface GetProductByNameUseCase {


    Optional<ProductModel> execute(String name);
}
