package service;

import entity.Category;
import entity.Question;
import repository.QuestionRepository;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class QuestionService {

    private final QuestionRepository questionRepository = new QuestionRepository();
    private final CategoryService categoryService = new CategoryService();

    public Question findById(Integer id) {
        return questionRepository.findById(id);
    }

    public Question findRandomByCategoryId(Integer id) throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        Category category = categoryService.findById(id);
        List<Question> questions = questionRepository.findAllByCategory(category);
        return questions.get((random.nextInt(questions.size())));
    }
}
