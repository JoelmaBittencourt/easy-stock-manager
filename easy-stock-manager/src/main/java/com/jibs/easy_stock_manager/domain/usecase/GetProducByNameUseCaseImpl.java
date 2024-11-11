package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProducByNameUseCaseImpl implements GetProductByNameUseCase {

    ProductGateway getProductGateway;

    public GetProducByNameUseCaseImpl(ProductGateway getProductGateway) {
        this.getProductGateway = getProductGateway;
    }


    @Override
    public Optional<ProductModel> execute(String name) {
        return getProductGateway.getByName(name);
    }


}


