package ak.test.thread;

import ak.test.repository.SessionRepository;

public class SessionDeleteThread implements Runnable {
    private final SessionRepository sessionRepository;
    private final long timeout;

    public SessionDeleteThread(SessionRepository sessionRepository, long timeout) {
        this.sessionRepository = sessionRepository;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        sessionRepository.deleteInactiveSessions(timeout);
    }
}
