import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        System.out.println(intersection(new int[]{4, 2, 1, 6}, new int[]{3, 6, 9, 2, 10}));
        System.out.println(intersection(new int[]{2, 4, 6}, new int[]{4, 2}));
        System.out.println(intersection(new int[]{4, 2, 1}, new int[]{1, 2, 4, 6}));
        System.out.println(intersection(new int[]{0, 1, 2}, new int[]{10, 11}));
        int [] list1 = new int[50000];
        for (int i = 0; i < list1.length; i ++)
            list1[i] = i;
        int [] list2 = new int[50000];
        for (int i = 0; i < list2.length; i ++)
            list2[i] = i;
        System.out.println(intersection(list1, list2));
    }

    private static List<Integer> intersection(int[] ints, int[] ints1) {
        Set<Integer> intsSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int item : ints)
            intsSet.add(item);
        for (int item: ints1)
            if (intsSet.contains(item))
                result.add(item);
        return result;
    }
}
