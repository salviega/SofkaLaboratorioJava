package Entity;

public class AnswerOption {

    private Long id;
    private String description;
    private Boolean isValid;
    private Question question;

    public AnswerOption() {
    }

    public AnswerOption(Long id, String description, Boolean isValid, Question question) {
        this.id = id;
        this.description = description;
        this.isValid = isValid;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
