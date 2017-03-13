package ak.test.model;

import ak.test.model.comparators.HighScoreComparator;

import java.util.*;
import java.util.stream.Collectors;

public class Level {
    private final String levelId;
    private Set<Score> scores;
    private final int limit;
    private final Comparator<Score> highScoreComparator;

    public Level(String levelId, int limit) {
        this.levelId = levelId;
        this.scores = new HashSet<>();
        this.limit = limit;
        this.highScoreComparator = new HighScoreComparator();
    }

    public String getLevelId() {
        return levelId;
    }

    public void addScore(Score score) {
        scores.add(score);
        scores = scores.stream().sorted(highScoreComparator).limit(limit).collect(Collectors.toSet());
    }

    public Set<Score> getScores() {
        return Collections.unmodifiableSet(scores);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level level = (Level) o;

        return levelId != null ? levelId.equals(level.levelId) : level.levelId == null;
    }

    @Override
    public int hashCode() {
        return levelId != null ? levelId.hashCode() : 0;
    }
}
