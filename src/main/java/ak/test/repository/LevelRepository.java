package ak.test.repository;

import ak.test.model.Level;

public interface LevelRepository {
    Level createLevel(String levelId);

    Level getLevel(String levelId);
}
