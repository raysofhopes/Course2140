import java.util.Arrays;

/*
source code from https://github.com/eugenp/tutorials/blob/master/algorithms-sorting/src/main/java/com/baeldung/algorithms/radixsort/RadixSort.java
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = {1, 5, 7, 25, 0, 8};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int a[]) {
        int maximumNumber = findMaximumNumberIn(a);
        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);
        int currDigit = 1;

        while (numberOfDigits-- > 0) {
            sort(a, currDigit);
            currDigit *= 10;
        }
    }

    private static void sort(int[] a, int currDigit) {
        int range = 10; // radix or the base

        int length = a.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {
            int value = (a[i] / currDigit) % range;
            frequency[value]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (a[i] / currDigit) % range;
            sortedValues[frequency[digit] - 1] = a[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, a, 0, length);//copy sorted values to a
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

}
