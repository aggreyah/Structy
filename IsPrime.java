public class IsPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(7));
        System.out.println(isPrime(9));
        System.out.println(isPrime(11));
        System.out.println(isPrime(1));
    }

    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.floor(Math.sqrt(n)); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
