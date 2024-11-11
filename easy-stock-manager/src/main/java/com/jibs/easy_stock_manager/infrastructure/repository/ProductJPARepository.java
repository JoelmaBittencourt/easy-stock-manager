package com.jibs.easy_stock_manager.infrastructure.repository;

import com.jibs.easy_stock_manager.infrastructure.adapter.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductJPARepository extends CrudRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByName(String name);
    List<ProductEntity> findByCategory(String category);

}
