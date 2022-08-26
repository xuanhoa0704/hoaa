package ntthanh.project.repository;

import ntthanh.project.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
}
