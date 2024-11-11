package com.jibs.easy_stock_manager.infrastructure.resource;

import com.jibs.easy_stock_manager.domain.model.ProductModel;
import com.jibs.easy_stock_manager.domain.usecase.*;
import com.jibs.easy_stock_manager.infrastructure.resource.mapper.ProductMapper;
import com.jibs.easy_stock_manager.infrastructure.resource.request.ProductRequest;
import com.jibs.easy_stock_manager.infrastructure.resource.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final CreateProductUsecase createProductUsecase;
    private final GetProductByNameUseCase getProductByNameUseCase;
    private final GetProductByCategoryUseCase getProductByCategoryUseCase;
    private final GetProductBySubCategoryUseCase getProductBySubCategoryUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final ProductMapper mapper;

    public ProductResource(CreateProductUsecase createProductUsecase, GetProductByNameUseCase getProductByNameUseCase, GetProductByCategoryUseCase getProductByCategoryUseCase, GetProductBySubCategoryUseCase getProductBySubCategoryUseCase, UpdateProductUseCase updateProductUseCase, GetProductUseCase getProductUseCase, ProductMapper mapper) {
        this.createProductUsecase = createProductUsecase;
        this.getProductByNameUseCase = getProductByNameUseCase;
        this.getProductByCategoryUseCase = getProductByCategoryUseCase;
        this.getProductBySubCategoryUseCase = getProductBySubCategoryUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.getProductUseCase = getProductUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Validated ProductRequest request) {
        ProductModel productModel = mapper.toModel(request);
        ProductModel createdProduct = createProductUsecase.usecase(productModel);
        return ResponseEntity.ok(mapper.toResponse(createdProduct));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = getProductUseCase.execute().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<ProductResponse>> geProductByName(
            @RequestHeader("product-name") String name) {
        List<ProductResponse> products = getProductByNameUseCase.execute(name).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<ProductResponse>> geProductByCategory(
            @RequestHeader("product-category") String name) {
        List<ProductResponse> products = getProductByCategoryUseCase.execute(name).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by-sub-category")
    public ResponseEntity<List<ProductResponse>> geProductBySubCategory(
            @RequestHeader("product-sub-category") String name) {
        List<ProductResponse> products = getProductBySubCategoryUseCase.execute(name).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(
            @RequestHeader("product") String name, @RequestBody ProductRequest request) {
        ProductModel productModel = mapper.toModel(request);
        ProductModel updatedProduct = updateProductUseCase.execute(name, productModel);
        return ResponseEntity.ok(mapper.toResponse(updatedProduct));
    }

}
