package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateProducUseCaseImpl implements UpdateProductUseCase{

    ProductGateway getProductGateway;

    public UpdateProducUseCaseImpl(ProductGateway getProductGateway) {
        this.getProductGateway = getProductGateway;
    }



    @Override
    public ProductModel execute(String name, ProductModel productModel) {
        return getProductGateway.update(name, productModel);
    }
}
