package ak.test.service.impl;

import ak.test.repository.impl.SessionRepositoryInMemory;
import ak.test.service.impl.impl.SessionServiceImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class SessionServiceImplTest {


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionIfLoginIsNull() {
        long timeout = 1l;
        SessionServiceImpl objectUnderTest = new SessionServiceImpl(timeout, new SessionRepositoryInMemory());
        objectUnderTest.login(null);
    }


    @Test
    public void shouldReturnUniqueSessionIdForUserId() {
        long timeout = 1l;
        SessionServiceImpl objectUnderTest = new SessionServiceImpl(timeout, new SessionRepositoryInMemory());
        String result = objectUnderTest.login("userId");
        assertNotNull(result);
    }

    @Test
    public void shouldReturnTheSameUniqueSessionIdForUserId() {
        long timeout = 100000l;
        SessionServiceImpl objectUnderTest = new SessionServiceImpl(timeout, new SessionRepositoryInMemory());
        String userId = "userId";
        String result = objectUnderTest.login(userId);
        assertNotNull(result);
        String anotherResult = objectUnderTest.login(userId);
        assertThat(anotherResult, is(result));
    }

    @Test
    public void shouldReturnNewSessionKeyForUserIdWhenOldSessionIsInactive() throws InterruptedException {
        long timeout = 1l;
        SessionServiceImpl objectUnderTest = new SessionServiceImpl(timeout, new SessionRepositoryInMemory());
        String userId = "userId";
        String result = objectUnderTest.login(userId);
        Thread.sleep(timeout);
        String anotherResult = objectUnderTest.login(userId);
        assertThat(anotherResult, is(not(result)));
    }


}