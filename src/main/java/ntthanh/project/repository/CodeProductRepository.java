package ntthanh.project.repository;

import ntthanh.project.entity.CodeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeProductRepository extends JpaRepository<CodeProduct, Integer> {
    CodeProduct findByProduct_ProductIdAndCode(String id, Integer code);
}
