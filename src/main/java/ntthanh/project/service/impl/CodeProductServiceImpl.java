package ntthanh.project.service.impl;

import ntthanh.project.entity.CodeProduct;
import ntthanh.project.service.CodeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntthanh.project.repository.CodeProductRepository;

@Service
public class CodeProductServiceImpl implements CodeProductService {
    @Autowired
    private CodeProductRepository codeProductRepository;
    @Override
    public void save(CodeProduct code) {
        this.codeProductRepository.save(code);
    }

    @Override
    public CodeProduct findByProduct(Integer id) {
        return null;
    }
}
