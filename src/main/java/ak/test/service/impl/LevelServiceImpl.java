package ak.test.service.impl;

import ak.test.model.Level;
import ak.test.model.Score;
import ak.test.model.User;
import ak.test.repository.LevelRepository;
import ak.test.service.LevelService;

public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public void addScore(int score, String levelId, User user) {
        Level level = levelRepository.getLevel(levelId);
        if (level == null) {
            level = levelRepository.createLevel(levelId);
        }
        level.addScore(new Score(score, user));
    }


}
