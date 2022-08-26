package ntthanh.project.service;

import ntthanh.project.dto.DtoProduct;
import ntthanh.project.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    Page<Product> finAll(Pageable pageable);
    List<Product> findAllListProduct();
    Product findById(String id);
    void saveProduct(DtoProduct product);
    void updateProduct(DtoProduct product);
    void delete(String id);
    List<Product> searchListProduct(String name);
    Page<Product> searchByCategory(String name, Pageable pageable);
}
