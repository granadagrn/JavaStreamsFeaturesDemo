package main.java.com.example.streams.model;

public class GenderActiveCountStats {

    private final long activeMales;
    private final long activeFemales;

    public GenderActiveCountStats(long activeMales, long activeFemales) {
        this.activeMales = activeMales;
        this.activeFemales = activeFemales;
    }

    public long getActiveMales() {
        return activeMales;
    }

    public long getActiveFemales() {
        return activeFemales;
    }
}
