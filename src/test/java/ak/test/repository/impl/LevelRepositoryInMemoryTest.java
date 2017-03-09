package ak.test.repository.impl;

import ak.test.model.Level;
import ak.test.model.Score;
import ak.test.model.User;
import ak.test.repository.LevelRepository;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LevelRepositoryInMemoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullLevelId() {
        LevelRepository objectUnderTest = new LevelRepositoryInMemory();
        objectUnderTest.createLevel(null);
    }

    @Test
    public void shouldCreateNewLevelWithLevelId() {
        LevelRepository objectUnderTest = new LevelRepositoryInMemory();
        String levelId = "level1";
        Level result = objectUnderTest.createLevel(levelId);
        assertThat(result.getLevelId(), is(levelId));
    }

    @Test
    public void shouldAddScoreValueForLevelId() {
        LevelRepository objectUnderTest = new LevelRepositoryInMemory();
        String levelId = "level1";
        Level level = objectUnderTest.createLevel(levelId);
        User user = new User();
        Score score = new Score(11, user);
        level.addScore(score);
        List<Score> scores = level.getScores();
        assertThat(scores.size(), is(1));
    }

}