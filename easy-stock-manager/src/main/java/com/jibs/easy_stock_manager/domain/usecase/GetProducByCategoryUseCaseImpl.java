package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProducByCategoryUseCaseImpl implements GetProductByCategoryUseCase {

    ProductGateway getProductGateway;

    public GetProducByCategoryUseCaseImpl(ProductGateway getProductGateway) {
        this.getProductGateway = getProductGateway;
    }


    @Override
    public List<ProductModel> execute(String category) {
        return getProductGateway.findByCategory(category);
    }
}
