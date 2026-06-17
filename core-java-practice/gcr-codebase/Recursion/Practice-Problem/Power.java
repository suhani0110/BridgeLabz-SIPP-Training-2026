public class Power {

    static long power(long x, int n) {
        if (n == 0)
            return 1;

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 5));
    }
}