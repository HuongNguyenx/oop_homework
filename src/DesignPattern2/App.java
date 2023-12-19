package DesignPattern2;

public class App {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 4, 2, 0, 10, 9, 30, 15 };

        Sort sort = new Sort();
        sort.setStrategy(new SelectionSort());
        sort.sortAsc(arr);

        for (int x : arr) {
            System.out.println(x);
        }
    }
}
