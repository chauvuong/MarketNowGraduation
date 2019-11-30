package com.sun.chau.repository;

import com.sun.chau.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    JpaRepository
    @Query(value = "select * from product where category_id in (select id from category where parent_id = :id) order by rating desc", nativeQuery = true)
    public List<Product> findAllByCategoryId(@Param("id") int categoryId);
}
