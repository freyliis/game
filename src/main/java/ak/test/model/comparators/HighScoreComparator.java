package ak.test.model.comparators;

import ak.test.model.Score;

public class HighScoreComparator implements java.util.Comparator<Score> {

    @Override
    public int compare(Score o1, Score o2) {
        return o2.getScore() - o1.getScore();
    }
}
