package DesignPattern2;

public class SelectionSort implements Strategy {
    @Override
    public void sortAsc(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = tmp;
        }
    }

    @Override
    public void sortDesc(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int indexMax = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[indexMax]) {
                    indexMax = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[indexMax];
            arr[indexMax] = tmp;
        }
    }
}
