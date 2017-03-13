package ak.test.repository;

import ak.test.model.Level;

import java.util.Optional;

public interface LevelRepository {
    Level createLevel(String levelId, int scoreListLimit);

    Optional<Level> getLevel(String levelId);
}
