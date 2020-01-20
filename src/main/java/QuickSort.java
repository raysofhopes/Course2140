public class QuickSort {
    public static void main(String[] args) {
        int[] a = {9, 7, 5, 8, 4, 1, -9};
        quickSort(a);
    }

    public static void quickSort(int a[]) {
        if (a == null) return;
        if (a.length < 2) return;
        quickSort(a, 0, a.length);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int a[], int start, int end) {
        if (2 == (end - start)) {
            if (a[start + 1] < a[start]) {
                swap(a, start, start + 1);
            }

        }
        if (start + 2 < end) {
            int pivotPosn = partition(a, start, end);

            quickSort(a, start, pivotPosn);
            quickSort(a, pivotPosn + 1, end);
        }
        //the third (base) case: 0 or 1 item to sort!
    }

    private static int partition(int a[], int start, int end) {
        int pivot = a[start];//let's say we choose the first element as pivot.
        int bigStart = (start + 1);

        for (int curr = start + 1; curr < end; curr++) {
            if (a[curr] < pivot) {
                swap(a, bigStart, curr);
                bigStart++;
            }
            //do nothing if it belongs in the bigs
        }

        swap(a, start, bigStart - 1);

        return bigStart - 1;
    }

    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
