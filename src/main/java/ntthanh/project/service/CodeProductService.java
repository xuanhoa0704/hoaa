package ntthanh.project.service;

import ntthanh.project.entity.CodeProduct;

public interface CodeProductService {
    void save(CodeProduct code);
    CodeProduct findByProduct(Integer id);
}
