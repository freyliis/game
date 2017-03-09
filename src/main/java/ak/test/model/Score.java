package ak.test.model;

public class Score {

    private int value;
    private User user;

    public Score(int value, User user) {
        this.user = user;
        this.value = value;
    }
}
