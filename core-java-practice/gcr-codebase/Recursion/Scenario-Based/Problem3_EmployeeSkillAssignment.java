import java.util.*;

public class Problem3_EmployeeSkillAssignment {

    static void findTeams(int[] arr, int index,
                          List<Integer> current,
                          int currentSum,
                          int target) {

        if (currentSum == target) {
            System.out.println(current);
        }

        if (index == arr.length || currentSum > target)
            return;

        current.add(arr[index]);

        findTeams(arr,
                index + 1,
                current,
                currentSum + arr[index],
                target);

        current.remove(current.size() - 1);

        findTeams(arr,
                index + 1,
                current,
                currentSum,
                target);
    }

    public static void main(String[] args) {

        int[] skills = {2, 3, 5, 7};
        int target = 10;

        findTeams(skills,
                0,
                new ArrayList<>(),
                0,
                target);
    }
}