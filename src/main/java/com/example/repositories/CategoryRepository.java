package com.example.repositories;

import com.example.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    <S extends Category> S save(S entity);

    Category findCategoryByTitle(String title);

}
