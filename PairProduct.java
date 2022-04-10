import java.util.*;

public class PairProduct {
    public static void main(String[] args) {
        System.out.println(pairProduct(new int[] {3, 2, 5, 4, 1}, 8));
        System.out.println(pairProduct(new int[] {3, 2, 5, 4, 1}, 10));
        System.out.println(pairProduct(new int[] {4, 7, 9, 2, 5, 1}, 5));
        System.out.println(pairProduct(new int[] {4, 7, 9, 2, 5, 1}, 35));
        System.out.println(pairProduct(new int[] {3, 2, 5, 4, 1}, 10));
        System.out.println(pairProduct(new int[] {4, 6, 8, 2}, 16));
    }

    private static List<Integer> pairProduct(int[] numbers, int targetProduct) {
        Map<Integer, Integer> previous = new HashMap<>();
        List<Integer> result = null;
        for (int i = 0; i < numbers.length; i++){
            int quotient = Math.floorDiv(targetProduct , numbers[i]);
            if (!previous.containsKey(quotient))
                previous.put(numbers[i], i);
            else {
                result = new ArrayList<>(Arrays.asList(previous.get(quotient), i));
            }
        }
        return result;
    }
}
