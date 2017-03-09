package ak.test.repository.impl;

import ak.test.model.Session;
import ak.test.repository.SessionRepository;

import java.util.HashMap;
import java.util.Map;

public class SessionRepositoryInMemory implements SessionRepository {

    private Map<String, Session> sessionRepository = new HashMap<>();

    @Override
    public Session createSession(String userId) {
        Session session = new Session();
        sessionRepository.put(userId, session);
        return session;
    }

    @Override
    public Session getSession(String userId) {
        return sessionRepository.get(userId);
    }

    public void deleteSession(String userId) {
        sessionRepository.remove(userId);
    }

    @Override
    public void deleteInactiveSessions(long timeout) {
        sessionRepository.entrySet().removeIf(entry -> !entry.getValue().isActiveSession(timeout));
    }
}
