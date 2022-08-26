package ntthanh.project.service.impl;

import ntthanh.project.entity.Categories;
import ntthanh.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntthanh.project.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Categories> finAll() {
        return this.categoryRepository.findAll();
    }
}
