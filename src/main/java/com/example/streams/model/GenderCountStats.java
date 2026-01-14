package main.java.com.example.streams.model;

public class GenderCountStats {
    private final long male;
    private final long female;

    public GenderCountStats(long male, long female) {
        this.male = male;
        this.female = female;
    }

    public long getMale() {
        return male;
    }

    public long getFemale() {
        return female;
    }
}
