package ak.test.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final String levelId;
    private final List<Score> scores;

    public Level(String levelId) {
        this.levelId = levelId;
        this.scores = new ArrayList<>();
    }

    public String getLevelId() {
        return levelId;
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    public List<Score> getScores() {
        return Collections.unmodifiableList(scores);
    }
}
