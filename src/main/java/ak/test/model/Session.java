package ak.test.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Session {

    private UUID sessionKey;
    private LocalDateTime creationTime;

    public Session() {
        this.sessionKey = UUID.randomUUID();
        this.creationTime = LocalDateTime.now();
    }

    public String getSessionKeyInString() {
        return sessionKey.toString();
    }

    public boolean isActiveSession(long timeout){
        long between = ChronoUnit.MICROS.between(this.creationTime, LocalDateTime.now());
        return between < timeout;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionKey=" + sessionKey +
                ", creationTime=" + creationTime +
                '}';
    }
}
