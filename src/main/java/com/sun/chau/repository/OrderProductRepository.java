package com.sun.chau.repository;

import com.sun.chau.entity.OrderProduct;
import com.sun.chau.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {
//    JpaRepository
@Query(value = "select * from order_product where account_id = :id", nativeQuery = true)
public List<OrderProduct> findAllByAccountId(@Param("id") int accountId);

    @Query(value = "select * from order_product where shipper_id = :id", nativeQuery = true)
    public List<OrderProduct> findAllByShipperId(@Param("id") int shipperId);
}