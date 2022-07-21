package com.example.demo.repository;



import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product where status = 0 and `name` like :name",
            countQuery = "SELECT count(*) FROM product where status = 0 and `name` like :name"
            ,nativeQuery = true)
    Page<Product> findAllSearch(@Param("name") String name, Pageable pageable);


    @Modifying
    @Query(value = "insert into product(`name`,price,description,producer) values(:name,:price,:description,:producer)", nativeQuery = true)
    void save(@Param("name") String name,
              @Param("price") Double price,
              @Param("description") String description,
              @Param("producer") String producer);

    @Modifying
    @Query(value = "update product set `name` = :name,price = :price, description = :description, producer = :producer where id = :id", nativeQuery = true)
    void updateProduct(@Param("name") String name,
                    @Param("price") Double price,
                    @Param("description") String description,
                    @Param("producer") String producer,
                    @Param("id") Integer id);


    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product findByIdProduct(@Param("id") Integer id);

    @Modifying
    @Query(value = " update product set status = 1 where id = :id", nativeQuery = true)
    void deleteProduct(@Param("id") Integer id);
}
