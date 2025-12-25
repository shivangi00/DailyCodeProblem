package Day01;
import java.util.HashSet;

public class solution {

    public boolean twoSum(int[] nums, int k) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            int diff = k - num;
            if (map.contains(diff)) {
                return true;
            } else{
                map.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solution sol = new solution();
        int[] nums = {10, 15, 3, 7};
        int k = 7;
        boolean ans = sol.twoSum(nums, k);
        System.out.println(ans);
    }
}