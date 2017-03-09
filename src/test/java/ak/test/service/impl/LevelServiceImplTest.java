package ak.test.service.impl;

import ak.test.model.User;
import ak.test.repository.impl.LevelRepositoryInMemory;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LevelServiceImplTest {

    @Test
    public void shouldAddScoreForUser() {
        LevelRepositoryInMemory levelRepository = new LevelRepositoryInMemory();
        LevelServiceImpl objectUnderTest = new LevelServiceImpl(levelRepository);
        String levelId = "level1";
        User user = new User();
        objectUnderTest.addScore(11, levelId, user);
        assertThat(levelRepository.getLevel(levelId).getScores().size(), is(1));
    }

}