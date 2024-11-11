package com.jibs.easy_stock_manager.domain.usecase;


import com.jibs.easy_stock_manager.domain.exception.DuplicateProductNameException;
import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateProductUsecaseImpl implements CreateProductUsecase {

    ProductGateway productGateway;


    public CreateProductUsecaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductModel usecase(ProductModel productModel) {
        validadeNameDuplicated(productModel.name());
        validateQuantity(productModel.quantity());
        validateExpireIn(productModel.expiryDate());
        validateStoreName(productModel.storeName());
        validateQuantityStars(productModel.reviewStars());
        validateAndTruncateAdditionalInfo(productModel.additionalInfo());
        return productGateway.create(productModel);
    }

    public void validadeNameDuplicated(String name) {
        final var nameProduct = productGateway.getByName(name);
        if (nameProduct.isPresent()) {
            throw new DuplicateProductNameException(
                    "Multiple products found with the name: " + name);
        }
    }

    public void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0: " + quantity);
        }
    }

    public void validateExpireIn(LocalDate expireIn) {
        if (expireIn.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The expiration date cannot be in the past.");
        }
    }

    public void validateStoreName(String storeName) {
        if (storeName.length() > 100) {
            throw new IllegalArgumentException("Store name must not exceed 100 characters." + storeName);
        }
    }

    public void validateQuantityStars(int stars) {
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Store name must not exceed 5 stars." + stars);
        }
    }

    public void validateAndTruncateAdditionalInfo(String info) {
        if (info != null && info.length() > 200) {
        }
    }


}

