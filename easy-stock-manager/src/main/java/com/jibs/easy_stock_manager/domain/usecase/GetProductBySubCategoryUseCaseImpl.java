package com.jibs.easy_stock_manager.domain.usecase;

import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductBySubCategoryUseCaseImpl implements GetProductBySubCategoryUseCase {

        ProductGateway productGateway;

    public GetProductBySubCategoryUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<ProductModel> execute(String subCategory) {
        return productGateway.findBySubCategory(subCategory);


    }
}
