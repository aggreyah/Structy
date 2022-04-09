public class Compress {
    public static void main(String[] args) {
        System.out.println(compress("ccaaatsss"));
        System.out.println(compress("nnneeeeeeeeeeeezz"));
        System.out.println(compress("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"));
    }

    private static String compress(String string) {
        String result = "";

        int i = 0, j = 0;

        while (i < string.length() && j < string.length()){
            int count = 0;
            if (string.charAt(i) == string.charAt(j)){
                j++;
                if (j == string.length()){
                    count = j - i;
                    if (count == 1)
                        result += String.format("%s", string.charAt(i));
                    else
                        result += String.format("%d%s", count, string.charAt(i));
                }

            }else{
                count = j - i;
                if (count == 1)
                    result += String.format("%s", string.charAt(i));
                else
                    result += String.format("%d%s", count, string.charAt(i));
                i = j;
            }
        }
        return  result;
    }
}
