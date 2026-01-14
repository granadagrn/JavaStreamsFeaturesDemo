package main.java.com.example.streams.model;

public class ActivePassiveCount {

    private final long active;
    private final long passive;

    public ActivePassiveCount(long active, long passive) {
        this.active = active;
        this.passive = passive;
    }

    public long getActive() {
        return active;
    }

    public long getPassive() {
        return passive;
    }
}
