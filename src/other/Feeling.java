package other;

public enum Feeling {
    Happy("радостно", "прыгать от счастья"),
    Sad("грусно", "смотреть в пустоту"),
    Nervous("волнительно", "переминаться с ноги на ногу"),
    Unusual("странно", "не понимать, что происходит"),
    Serious("серьезно", "сидеть с напыженным лицом");
    private String description;
    private String action;

    Feeling(String description, String action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
