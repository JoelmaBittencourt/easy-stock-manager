package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.model.ProductModel;

import java.util.List;

public interface GetProductByCategoryUseCase {


    List<ProductModel> execute(String category);
}
