package entity;

public class AnswerOption {

    private Integer id;
    private String description;
    private Boolean isValid;
    private Question question;

    public AnswerOption() {
    }

    public AnswerOption(Integer id, String description, Boolean isValid, Question question) {
        this.id = id;
        this.description = description;
        this.isValid = isValid;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
