package com.jibs.easy_stock_manager.domain.usecase;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.jibs.easy_stock_manager.domain.exception.DuplicateProductNameException;
import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import com.jibs.easy_stock_manager.domain.usecase.CreateProductUsecaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class CreateProductUsecaseTest {

    private final ProductModel PRODUCT = ProductModel.builder()
            .name("Sample Product")
            .price(BigDecimal.valueOf(33.88))
            .quantity(10)
            .usedQuantity(2)
            .description("A sample product description")
            .marca("Apse")
            .reviewStars(5)
            .purchaseDate(LocalDate.now().minusDays(5))
            .expiryDate(LocalDate.now().plusDays(30))
            .storeName("Sample Store")
            .category("Sample Category")
            .build();
    private final ProductModel PRODUCT_EXCEPTION = ProductModel.builder()
            .name("Sample Product")
            .price(BigDecimal.valueOf(33.88))
            .quantity(10)
            .usedQuantity(2)
            .description("A sample product description")
            .reviewStars(5)
            .purchaseDate(LocalDate.now().minusDays(5))
            .expiryDate(LocalDate.now().plusDays(30))
            .storeName("Sample Store")
            .category("Sample Category")
            .build();
    @Mock
    private ProductGateway gateway;
    @InjectMocks
    private CreateProductUsecaseImpl createProductUsecase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should create a product successfully")
    @Test
    void shouldCreateProductSuccessfully() {
        when(gateway.create(PRODUCT)).thenReturn(PRODUCT);

        ProductModel result = createProductUsecase.usecase(PRODUCT);

        assertEquals(PRODUCT.name(), result.name());
        assertEquals(PRODUCT.price(), result.price());
        assertEquals(PRODUCT.quantity(), result.quantity());
        assertEquals(PRODUCT.usedQuantity(), result.usedQuantity());
        assertEquals(PRODUCT.description(), result.description());
        assertEquals(PRODUCT.reviewStars(), result.reviewStars());
        assertEquals(PRODUCT.purchaseDate(), result.purchaseDate());
        assertEquals(PRODUCT.expiryDate(), result.expiryDate());
        assertEquals(PRODUCT.marca(), result.marca());
        assertEquals(PRODUCT.storeName(), result.storeName());
        assertEquals(PRODUCT.category(), result.category());

        verify(gateway).create(PRODUCT);
    }

    @DisplayName("Should throw DuplicateProductNameException when product with duplicate name is created")
    @Test
    void shouldThrowDuplicateProductNameExceptionWhenProductWithDuplicateNameIsCreated() {
        String duplicateName = "Duplicate Product";

        ProductModel firstProduct = ProductModel.builder()
                .name(duplicateName)
                .price(BigDecimal.valueOf(20.00))
                .quantity(5)
                .usedQuantity(1)
                .description("First product with duplicate name")
                .marca("Apse")
                .reviewStars(4)
                .purchaseDate(LocalDate.now().minusDays(5))
                .expiryDate(LocalDate.now().plusDays(10))
                .storeName("Sample Store")
                .category("Sample Category")
                .build();

        when(gateway.getByName(duplicateName))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(firstProduct));

        createProductUsecase.usecase(firstProduct);

        DuplicateProductNameException exception = assertThrows(DuplicateProductNameException.class, () ->
                createProductUsecase.usecase(firstProduct)
        );

        assertEquals("Multiple products found with the name: " + duplicateName, exception.getMessage());

        verify(gateway, times(2)).getByName(duplicateName);
        verify(gateway, times(1)).create(firstProduct);
    }

    @DisplayName("Should throw IllegalArgumentException for invalid quantity")
    @Test
    void shouldThrowIllegalArgumentExceptionForInvalidQuantity() {
        ProductModel firstProduct2 = ProductModel.builder()
                .name("name product")
                .price(BigDecimal.valueOf(20.00))
                .quantity(-5)
                .usedQuantity(1)
                .description("First product with invalid quantity")
                .marca("Apse")
                .reviewStars(4)
                .purchaseDate(LocalDate.now().minusDays(5))
                .expiryDate(LocalDate.now().plusDays(10))
                .storeName("Sample Store".repeat(101))
                .category("Sample Category")
                .build();

        when(gateway.create(firstProduct2)).thenReturn(PRODUCT);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                createProductUsecase.usecase(firstProduct2)
        );

        assertEquals("Quantity must be greater than 0: " + firstProduct2.quantity(), exception.getMessage());
    }

    @DisplayName("Should throw IllegalArgumentException for product with overly long store name")
    @Test
    void shouldThrowIllegalArgumentExceptionForProductWithOverlyLongStoreName() {
        String duplicateName = "Duplicate Product";

        ProductModel firstProduct2 = ProductModel.builder()
                .name(duplicateName)
                .price(BigDecimal.valueOf(20.00))
                .quantity(4)
                .usedQuantity(1)
                .description("Product with overly long store name")
                .marca("Apse")
                .reviewStars(4)
                .purchaseDate(LocalDate.now().minusDays(5))
                .expiryDate(LocalDate.now().plusDays(10))
                .storeName("Sample Store".repeat(101))
                .category("Sample Category")
                .build();

        when(gateway.create(firstProduct2)).thenReturn(PRODUCT);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                createProductUsecase.usecase(firstProduct2)
        );
    }

    @DisplayName("Should throw IllegalArgumentException for invalid purchase and expiry dates")
    @Test
    void shouldThrowIllegalArgumentExceptionForInvalidPurchaseAndExpiryDates() {
        String duplicateName = "Duplicate Product";
        LocalDate today = LocalDate.now();

        ProductModel firstProduct2 = ProductModel.builder()
                .name(duplicateName)
                .price(BigDecimal.valueOf(20.00))
                .quantity(4)
                .usedQuantity(1)
                .description("Product with invalid purchase and expiry dates")
                .marca("Apse")
                .reviewStars(4)
                .purchaseDate(LocalDate.now().plusDays(10))
                .expiryDate(today.minusDays(10))
                .storeName("Sample Store")
                .category("Sample Category")
                .build();

        when(gateway.create(firstProduct2)).thenReturn(PRODUCT);

        assertThrows(IllegalArgumentException.class, () ->
                createProductUsecase.usecase(firstProduct2)
        );
    }
}
