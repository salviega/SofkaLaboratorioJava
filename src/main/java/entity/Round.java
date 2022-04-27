package entity;

public class Round {

    private Integer id;
    private String description;
    private Reward reward;
    private Category category;

    public Round() {
    }

    public Round(Integer id, String description, Reward reward, Category category) {
        this.id = id;
        this.description = description;
        this.reward = reward;
        this.category = category;
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

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
