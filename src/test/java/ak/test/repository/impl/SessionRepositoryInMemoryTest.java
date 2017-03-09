package ak.test.repository.impl;

import ak.test.model.Session;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SessionRepositoryInMemoryTest {

    private SessionRepositoryInMemory objectUnderTest;

    @Before
    public void setUp() {
        objectUnderTest = new SessionRepositoryInMemory();
    }

    @Test
    public void shouldCreateAndReturnAndDeleteExistingSessionForUserId() {
        String userId = "userId";
        Session result = objectUnderTest.createSession(userId);
        assertNotNull(result);
        Session getResult = objectUnderTest.getSession(userId);
        assertThat(getResult, is(result));
        objectUnderTest.deleteSession(userId);
        Session deletedResult = objectUnderTest.getSession(userId);
        assertThat(deletedResult, nullValue());
    }


    @Test
    public void shouldDeleteInactiveSessions() {
        String userId = "userId";
        Session inactiveSessionToBeDeleted = objectUnderTest.createSession(userId);
        assertNotNull(inactiveSessionToBeDeleted);
        objectUnderTest.deleteInactiveSessions(1l);
        Session result = objectUnderTest.getSession(userId);
        assertNull(result);

    }

}