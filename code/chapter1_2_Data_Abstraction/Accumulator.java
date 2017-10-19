package chapter1_2_Data_Abstraction;

public class Accumulator {
    private double total;
    private int N;
    public void addDataValue(double val) {
        N++;
        total += val;
    }
    public double mean() {
        return total / N;
    }
    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }
}
