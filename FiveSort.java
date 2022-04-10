import java.util.Arrays;

public class FiveSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fiveSort(new int[]{12, 5, 1, 5, 12, 7})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 2, 5, 6, 5, 1, 10, 2, 5, 5})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 5, 5, 1, 1, 1, 4})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 5, 6, 5, 5, 5, 5})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 1, 2, 5, 5, 3, 2, 5, 1, 5, 5, 5, 4, 5})));
    }

    private static int [] fiveSort(int[] ints) {
        int i = 0, j = ints.length - 1;
        while (i <= j){
            if (ints[i] == 5){
                if (ints[j] != 5){
                    swap(i, j, ints);
                    j--;
                    i++;
                }
            }
            else
                i++;

            if (ints[j] == 5){
                j--;
            }
        }
        return ints;
    }

    private static void swap(int i, int j, int[] anArray) {
        int temp = anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = temp;
    }
}
