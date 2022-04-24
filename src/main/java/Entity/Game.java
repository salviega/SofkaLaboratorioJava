package Entity;

public class Game {

    private Long id;
    private Integer accumulated;
    private Status status;
    private Round round;
    private Player player;

    public Game() {
    }

    public Game(Long id, Integer accumulated, Status status, Round round, Player player) {
        this.id = id;
        this.accumulated = accumulated;
        this.status = status;
        this.round = round;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccumulated() {
        return accumulated;
    }

    public void setAccumulated(Integer accumulated) {
        this.accumulated = accumulated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
