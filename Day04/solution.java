package Day04;

public class solution {
	public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean one = false;

        // Step 1: Clean array and check for presence of 1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                one = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;   // ✅ modify the array
            }
        }

        if (!one) {
            return 1;
        }

        // Step 2: Mark presence using index
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Step 3: Find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }


    public static void main(String[] args) {
        solution s = new solution();
        int[] nums = {9,12,4,1,3,-1,8};
        int ans = s.firstMissingPositive(nums);
        System.out.println(ans);
    }
}
