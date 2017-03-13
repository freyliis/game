package ak.test.repository.impl;

import ak.test.model.Level;
import ak.test.model.Score;
import ak.test.model.User;
import ak.test.repository.LevelRepository;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LevelRepositoryInMemoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullLevelId() {
        LevelRepository objectUnderTest = new LevelRepositoryInMemory();
        objectUnderTest.createLevel(null, 1);
    }

    @Test
    public void shouldCreateNewLevelWithLevelId() {
        LevelRepository objectUnderTest = new LevelRepositoryInMemory();
        String levelId = "level1";
        Level result = objectUnderTest.createLevel(levelId, 1);
        assertThat(result.getLevelId(), is(levelId));
    }

    @Test
    public void shouldAddScoreValueForLevelId() {
        LevelRepository objectUnderTest = new LevelRepositoryInMemory();
        String levelId = "level1";
        Level level = objectUnderTest.createLevel(levelId, 1);
        User user = new User("userId");
        Score score = new Score(11, user);
        level.addScore(score);
        Set<Score> scores = level.getScores();
        assertThat(scores.size(), is(1));
    }

    @Test
    public void shouldNotAddScoreValueForLevelIdBecauseLimitIs0() {
        LevelRepository objectUnderTest = new LevelRepositoryInMemory();
        String levelId = "level1";
        Level level = objectUnderTest.createLevel(levelId, 0);
        User user = new User("userId");
        Score score = new Score(11, user);
        level.addScore(score);
        Set<Score> scores = level.getScores();
        assertThat(scores.size(), is(0));
    }

}
