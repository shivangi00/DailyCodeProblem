package Day02;

public class solution {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		int[] ans = new int[n];

		prefix[0] = 1;
		suffix[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] * nums[i - 1];
		}
		
		for (int i = n - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < n; i++){
			ans[i] = prefix[i] * suffix[i];
		}

		return ans;
	}
	public static void main(String[] args) {
		solution s = new solution();
		int[] nums = {1,2,3,4};
        int[] ans = s.productExceptSelf(nums);
		for (int num : ans) {
            System.out.print(num + " ");
        }
	}    
}
