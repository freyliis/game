package ak.test.repository;

import ak.test.model.Session;

public interface SessionRepository {
    Session createSession(String userId);

    Session getSession(String userId);

    void deleteSession(String userId);

    void deleteInactiveSessions(long timeout);

}
