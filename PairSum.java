import java.util.*;

public class PairSum {
    public static void main(String[] args) {
        System.out.println(pairSum(new int[] {3, 2, 5, 4, 1}, 8));
        System.out.println(pairSum(new int[] {4, 7, 9, 2, 5, 1}, 5));
        System.out.println(pairSum(new int[] {4, 7, 9, 2, 5, 1}, 3));
        System.out.println(pairSum(new int[] {1, 6, 7, 2}, 13));
        System.out.println(pairSum(new int[] {9, 9}, 18));
        System.out.println(pairSum(new int[] {6, 4, 2, 8}, 12));
    }

    private static List<Integer> pairSum(int[] numbers, int targetSum) {
        // create a map of previously seen int array elements with their indices as values
        Map<Integer, Integer> previous = new HashMap<>();
        List<Integer> result = null;
        int compliment;
        for (int i = 0; i < numbers.length; i++){
            compliment = targetSum - numbers[i];
            if (!previous.containsKey(compliment))
                previous.put(numbers[i], i);
            else{
                result = new ArrayList<>(Arrays.asList(previous.get(compliment), i));
                break;
            }
        }
        return result;
    }
}
