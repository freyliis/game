package ak.test.thread;

import ak.test.model.Session;
import ak.test.repository.SessionRepository;
import ak.test.repository.impl.SessionRepositoryInMemory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionDeleteThreadTest {

    @Test
    public void shouldRemoveInactiveSession() {
        SessionRepository sessionRepository = new SessionRepositoryInMemory();
        String userId = "userId";
        sessionRepository.createSession(userId);
        SessionDeleteThread thread = new SessionDeleteThread(sessionRepository, 1l);

        thread.run();

        Session result = sessionRepository.getSession(userId);
        assertNull(result);
    }

}