package ak.test.service.impl;

import ak.test.model.Level;
import ak.test.model.Score;
import ak.test.model.User;
import ak.test.repository.LevelRepository;
import ak.test.service.LevelService;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final int scoreListLimitInLevel;

    public LevelServiceImpl(LevelRepository levelRepository, int scoreListLimitInLevel ) {
        this.levelRepository = levelRepository;
        this.scoreListLimitInLevel = scoreListLimitInLevel;
    }

    @Override
    public void addScore(int score, String levelId, User user) {
        Optional<Level> level = levelRepository.getLevel(levelId);
        if (!level.isPresent()) {
           level = Optional.of(levelRepository.createLevel(levelId, scoreListLimitInLevel));
        }
        level.get().addScore(new Score(score, user));
    }

    @Override
    public Set<Score> getHighScoreList(String levelId) {
        Optional<Level> level = levelRepository.getLevel(levelId);
        if(level.isPresent()) {
            return level.get().getScores();
        } else {
            return Collections.emptySet();
        }
    }


}
