package main.java.com.example.streams.model;

public class AgeSummaryStats {

    private final double ageAvg;
    private final int maxAge;

    public AgeSummaryStats(double ageAvg, int maxAge) {
        this.ageAvg = ageAvg;
        this.maxAge = maxAge;
    }

    public double getAgeAvg() {
        return ageAvg;
    }

    public int getMaxAge() {
        return maxAge;
    }
}
