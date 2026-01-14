package main.java.com.example.streams.model;

public class CustomerStats {
    private final long count;
    private final double averageAge;

    public CustomerStats(long count, double averageAge) {
        this.count = count;
        this.averageAge = averageAge;
    }

    public long getCount() {
        return count;
    }

    public double getAverageAge() {
        return averageAge;
    }

    @Override
    public String toString() {
        return "CustomerStats{count=" + count + ", averageAge=" + averageAge + '}';
    }
}

