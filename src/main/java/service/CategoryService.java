package service;

import entity.Category;
import repository.CategoryRepository;

public class CategoryService {

    private final CategoryRepository categoryRepository = new CategoryRepository();

    public Category findById(Integer id) {
        return categoryRepository.findById(id);
    }

}
