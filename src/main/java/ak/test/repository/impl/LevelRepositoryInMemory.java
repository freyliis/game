package ak.test.repository.impl;

import ak.test.model.Level;
import ak.test.repository.LevelRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class LevelRepositoryInMemory implements LevelRepository {

    private Set<Level> levels = new HashSet<>();

    @Override
    public Level createLevel(String levelId) {
        if (levelId == null || levelId.length() == 0) {
            throw new IllegalArgumentException();
        }
        Level level = new Level(levelId);
        levels.add(level);
        return level;
    }

    @Override
    public Level getLevel(String levelId) {
        Optional<Level> level = levels.stream().filter(value -> value.getLevelId().equals(levelId)).findFirst();
        if (level.isPresent()) {
            return level.get();
        }
        return null;
    }
}
