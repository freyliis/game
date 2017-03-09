package ak.test.service;

import ak.test.model.User;

public interface LevelService {
    void addScore(int score, String levelId, User user);
}
