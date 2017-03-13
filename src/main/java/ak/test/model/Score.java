package ak.test.model;

public class Score {

    private int score;
    private User user;

    public Score(int score, User user) {
        this.user = user;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        return user != null ? user.equals(score.user) : score.user == null;
    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }
}
