import java.util.*;

public class Subsets {

    static void generate(int[] arr, int index, List<Integer> subset) {

        if (index == arr.length) {
            System.out.println(subset);
            return;
        }

        generate(arr, index + 1, subset);

        subset.add(arr[index]);
        generate(arr, index + 1, subset);

        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2};

        generate(arr, 0, new ArrayList<>());
    }
}