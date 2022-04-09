import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(anagrams("restful", "fluster"));
        System.out.println(anagrams("cats", "tocs"));
        System.out.println(anagrams("monkeyswrite", "newyorktimes"));
        System.out.println(anagrams("paper", "reapa"));
        System.out.println(anagrams("elbow", "below"));
        System.out.println(anagrams("tax", "taxi"));
        System.out.println(anagrams("taxi", "tax"));
        System.out.println(anagrams("night", "thing"));
        System.out.println(anagrams("bbc", "aabc"));
    }

    private static boolean anagrams(String string1, String string2) {
        return charCount(string1).equals(charCount(string2));
    }

    private static Map<Character, Integer> charCount(String string) {
        Map<Character, Integer> count = new HashMap<>();
        for (char item : string.toCharArray()){
            if (!count.containsKey(item))
                count.put(item, 0);
            count.replace(item, count.get(item) + 1);
        }
        return count;
    }
}
