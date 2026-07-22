import java.util.*;

public class SubarraySumEqualsK {

    public static int subarraySumEqualsK(int[] arr,int k){

        Map<Integer,Integer> prefixCount = new HashMap<>();

        prefixCount.put(0,1);

        int sum = 0;
        int answer = 0;

        for(int num : arr){

            sum += num;

            answer += prefixCount.getOrDefault(sum-k,0);

            prefixCount.put(sum,prefixCount.getOrDefault(sum,0)+1);
        }

        return answer;
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,-2,2};

        System.out.println(subarraySumEqualsK(arr,3));
    }
}