import java.util.HashMap;
import java.util.Map;

public class MostFrequentChar {
    public static void main(String[] args) {
        System.out.println(mostFrequentChar("bookeeper"));
        System.out.println(mostFrequentChar("david"));
        System.out.println(mostFrequentChar("abby"));
        System.out.println(mostFrequentChar("mississippi"));
        System.out.println(mostFrequentChar("potato"));
        System.out.println(mostFrequentChar("eleventennine"));
        System.out.println(mostFrequentChar("riverbed"));
    }

    private static char mostFrequentChar(String string) {
        Map<Character, Integer> count = charCount(string);
        Character mostFrequent = null;
        for (Character item: string.toCharArray()){
            if (mostFrequent == null || count.get(item) > count.get(mostFrequent))
                mostFrequent = item;
        }
        return mostFrequent;
    }

    private static Map<Character, Integer> charCount(String string) {
        Map<Character, Integer> count = new HashMap<>();
        for (Character item : string.toCharArray()){
            if (!count.containsKey(item))
                count.put(item, 0);
            count.replace(item, count.get(item) + 1);
        }
        return count;
    }
}
