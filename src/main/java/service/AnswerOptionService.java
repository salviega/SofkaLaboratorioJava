package service;

import entity.AnswerOption;
import entity.Question;
import repository.AnswerOptionRepository;

import java.util.Collections;
import java.util.List;

public class AnswerOptionService {

    private final AnswerOptionRepository answerOptionRepository = new AnswerOptionRepository();
    private final QuestionService questionService = new QuestionService();

    public AnswerOption findById(Integer id) {
        return answerOptionRepository.findById(id);
    }

    public List<AnswerOption> findAnswerOptionsByQuestionId(Integer id) {
        Question question = questionService.findById(id);

        List<AnswerOption> answerOptions = answerOptionRepository.findAllByQuestion(question);
        Collections.shuffle(answerOptions);
        return answerOptions;
    }
}
