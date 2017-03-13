package ak.test.service.impl;

import ak.test.model.Score;
import ak.test.model.User;
import ak.test.repository.impl.LevelRepositoryInMemory;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LevelServiceImplTest {

    @Test
    public void shouldAddScoresForTwoUsersAndReturn10AsHighScoreNoDuplicatesForUser() {
        LevelRepositoryInMemory levelRepository = new LevelRepositoryInMemory();
        LevelServiceImpl objectUnderTest = new LevelServiceImpl(levelRepository, 15);
        String levelId = "level1";
        User user1 = new User("userId1");
        objectUnderTest.addScore(10, levelId, user1);
        objectUnderTest.addScore(9, levelId, user1);
        User user2 = new User("userId2");
        objectUnderTest.addScore(9, levelId, user2);
        objectUnderTest.addScore(8, levelId, user2);
        assertThat(levelRepository.getLevel(levelId).get().getScores().size(), is(2));
        Set<Score> highScoreListResult = objectUnderTest.getHighScoreList(levelId);
        assertThat(highScoreListResult.size(), is(2));
        Score[] scores = highScoreListResult.toArray(new Score[highScoreListResult.size()]);
        assertThat(scores[0].getScore(), is(10));
        assertThat(scores[0].getUser().getUserId(), is(user1.getUserId()));
        assertThat(scores[1].getScore(), is(9));
        assertThat(scores[1].getUser().getUserId(), is(user2.getUserId()));
    }
}