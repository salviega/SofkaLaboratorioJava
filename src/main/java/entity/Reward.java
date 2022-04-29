package entity;

public class Reward {

    private Integer id;
    private String description;
    private Integer amount;

    public Reward() {
    }

    public Reward(Integer id, String description, int amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
