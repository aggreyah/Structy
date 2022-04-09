public class Uncompress {
    public static void main(String[] args) {
        System.out.println(uncompress("22c3a"));
        System.out.println(uncompress("2c3a1t"));
    }

    private static String uncompress(String compressed) {
        String numbers = "0123456789";
        String result = "";
        int i = 0, j = 1;
        while (i < compressed.length() && j < compressed.length()){
            if (numbers.indexOf(compressed.substring(j, j+1)) == -1){
                Integer num = Integer.parseInt(compressed.substring(i, j));
                result += compressed.substring(j, j + 1).repeat(num);
                i = j + 1;
                j = i + 1;
            }else
                j += 1;
        }
        return  result;
    }
}
