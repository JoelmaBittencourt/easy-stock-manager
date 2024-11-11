package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProducUseCaseImpl implements GetProductUseCase {

    ProductGateway getProductGateway;

    public GetProducUseCaseImpl(ProductGateway getProductGateway) {
        this.getProductGateway = getProductGateway;
    }


    @Override
    public List<ProductModel> execute() {
        return getProductGateway.getAll();
    }
}
