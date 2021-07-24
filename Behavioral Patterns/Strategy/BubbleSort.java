package Strategy;

import java.util.Arrays;

public class BubbleSort implements ISort {

    @Override
    public void sort(int[] input) {
        // Do inefficient sorting in order n squared
        Arrays.sort(input);
    }
}