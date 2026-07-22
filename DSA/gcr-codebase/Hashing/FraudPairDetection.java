import java.util.*;

public class FraudPairDetection {

    public static int[] findFraudPair(int[] amounts,int target){

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<amounts.length;i++){

            int complement = target - amounts[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

            map.put(amounts[i],i);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args){

        int[] amounts = {4,7,11,15};

        System.out.println(Arrays.toString(findFraudPair(amounts,18)));
    }
}