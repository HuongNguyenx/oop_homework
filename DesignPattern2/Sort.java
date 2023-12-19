package DesignPattern2;

public class Sort {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sortAsc(int[] arr) {
        strategy.sortAsc(arr);
    }

    public void sortDesc(int[] arr) {
        strategy.sortDesc(arr);
    }
}
