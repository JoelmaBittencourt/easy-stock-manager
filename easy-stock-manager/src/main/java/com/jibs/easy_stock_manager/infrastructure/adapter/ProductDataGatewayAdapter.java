package com.jibs.easy_stock_manager.infrastructure.adapter;

import com.jibs.easy_stock_manager.domain.gateway.ProductGateway;
import com.jibs.easy_stock_manager.domain.model.ProductModel;
import com.jibs.easy_stock_manager.infrastructure.adapter.entity.ProductEntity;
import com.jibs.easy_stock_manager.infrastructure.adapter.mapper.ProductDataGatewayMapper;
import com.jibs.easy_stock_manager.infrastructure.repository.ProductJPARepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDataGatewayAdapter implements ProductGateway {

    private final ProductJPARepository repository;
    private final ProductDataGatewayMapper mapper;

    public ProductDataGatewayAdapter(ProductJPARepository repository, ProductDataGatewayMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductModel create(ProductModel product) {
        var entity = mapper.toEntity(product);
        ProductEntity savedEntity = repository.save(entity);
        return mapper.toModel(savedEntity);
    }

    @Override
    public List<ProductModel> getAll() {
        List<ProductEntity> entities = (List<ProductEntity>) repository.findAll();
        return entities.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public List<ProductModel> findByCategory(String category) {
        List<ProductEntity> entities;
        entities = repository.findByCategory(category);
        return entities.stream()
                .map(mapper::toModel)
                .toList();
    }



    @Override
    public List<ProductModel> findBySubCategory(String subCategory) {
        List<ProductEntity> entities;
        entities = repository.findByCategory(subCategory);
        return entities.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public ProductModel update(String name, ProductModel product) {
        ProductEntity existingEntity = repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with name: " + name));
        var entityToUpdate = mapper.toEntity(product);
        entityToUpdate.setId(existingEntity.getId());
        ProductEntity updatedEntity = repository.save(entityToUpdate);
        return mapper.toModel(updatedEntity);
    }


    @Override
    public Optional<ProductModel> getByName(String name) {
        return repository.findByName(name).map(mapper::toModel);
    }
}
