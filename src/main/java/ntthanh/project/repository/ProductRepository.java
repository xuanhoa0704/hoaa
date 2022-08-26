package ntthanh.project.repository;

import ntthanh.project.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByCategories(String name, Pageable pageable);


    @Query("select p "+"from Product p " +
            "inner join Categories c on c.categoryId = p.categories.categoryId " +
            "where p.productId like %:key% " +
            "or p.productName like %:key% " +
            "or p.productPrice like %:key% " +
            "or p.productQuantity like %:key% " +
            "or p.expiry like %:key% " +
            "or p.trademark like %:key% " +
            "or c.categoryName like %:key%"
    )
    Page<Product> searchProduct(@Param("key") String name,Pageable pageable);

    @Query("select p "+"from Product p " +
            "inner join Categories c on c.categoryId = p.categories.categoryId " +
            "where p.productId like %:key% " +
            "or p.productName like %:key% " +
            "or p.productPrice like %:key% " +
            "or p.productQuantity like %:key% " +
            "or p.expiry like %:key% " +
            "or p.trademark like %:key% " +
            "or c.categoryName like %:key%"
    )
    List<Product> searchListProduct(@Param("key") String name);
}
