package ak.test.service.impl;

import ak.test.model.Session;
import ak.test.repository.SessionRepository;
import ak.test.service.impl.SessionService;

public class SessionServiceImpl implements SessionService {


    private final SessionRepository sessionRepository;
    private final long timeout;

    public SessionServiceImpl(long timeout, SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
        this.timeout = timeout;
    }

    public String login(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException();
        }
        Session session = sessionRepository.getSession(userId);
        if (session != null && session.isActiveSession(timeout)) {
            return session.getSessionKeyInString();
        }
        return sessionRepository.createSession(userId).getSessionKeyInString();
    }
}
