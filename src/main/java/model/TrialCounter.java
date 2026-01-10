package model;

public class TrialCounter {
    private int trials;

    private void increment() {
        trials++;
    }

    private boolean failCheck() {
        return trials > 6;
    }
}
