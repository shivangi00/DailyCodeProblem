package Day04;

public class solution {
	public int firstMissingPositive(int[] nums) {
		// mark all out of range elements and mark presence of 1
		int n = nums.length;
		boolean one = false;
		for (int num : nums) {
			if (num == 1) { one = true;}
			if (num < 0 || num > n + 1) {
				num = 1;
			}
		}

        if (!one) {
            return 1;
        }

		// map elements with index
		for (int i = 0; i < n; i++) {
            int currIndex = Math.abs(nums[i]) - 1;
			if (currIndex < n && nums[currIndex] > 0) {
                nums[currIndex] = -nums[currIndex];
            }
		}

		// find missing positive
		for (int num : nums) {
			if (num > 0) {
				return num - 1;
			}
		}

        return n + 1;
	}

    public static void main(String[] args) {
        solution s = new solution();
        int[] nums = {9,12,4,1,2,-1,8};
        int ans = s.firstMissingPositive(nums);
        System.out.println(ans);
    }
}
