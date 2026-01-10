package model;

public class TrialCounter {
    private int trials = 0;

    public void increment() {
        trials++;
    }

    public boolean failCheck() {
        return trials > 6;
    }

    public int getTrials() {
        return trials;
    }
}
