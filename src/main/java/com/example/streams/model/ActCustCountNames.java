package main.java.com.example.streams.model;

import java.util.List;

public class ActCustCountNames {

    private final int actCustCount;
    private final List<String> actCustNames;

    public ActCustCountNames(int actCustCount, List<String> actCustNames) {
        this.actCustCount = actCustCount;
        this.actCustNames = actCustNames;
    }

    public int getActCustCount() {
        return actCustCount;
    }

    public List<String> getActCustNames() {
        return actCustNames;
    }
}
