public class SqrtX69 {

    public static int mySqrt(int x) {

        if (x == 0 || x == 1)
            return x;

        int low = 1;
        int high = x;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if ((long) mid * mid == x)
                return mid;

            if ((long) mid * mid < x)
                low = mid + 1;
            else
                high = mid - 1;

        }

        return high;

    }

    public static void main(String[] args) {

        System.out.println(mySqrt(4));

        System.out.println(mySqrt(8));

    }

}