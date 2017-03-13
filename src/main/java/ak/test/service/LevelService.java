package ak.test.service;

import ak.test.model.Score;
import ak.test.model.User;

import java.util.Set;

public interface LevelService {
    void addScore(int score, String levelId, User user);

    Set<Score> getHighScoreList(String levelId);
}
