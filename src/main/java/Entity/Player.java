package Entity;

public class Player {

    private Long id;
    private String description;
    private Category category;

    public Player() {
    }

    public Player(Long id, String description, Category category) {
        this.id = id;
        this.description = description;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
