package Day13;

public class solution {
    public int longestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLen = -1;
        int count = 0;
        int[] freq = new int[128];

        while (end < n) {
            // add the character and its frequency to array
            freq[s.charAt(end) - 'a']++;
            // if distinct charcater found, increment count
            if(freq[s.charAt(end) - 'a'] == 1) {
                count++;
            }
            // check if count has exceeded distinct char limit
            while (count > k) {
                freq[s.charAt(start) - 'a']--;
                if(freq[s.charAt(start) - 'a'] == 0) {
                    count--;
                }
                start++;
            }

            if(count == k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        solution sol = new solution();
        int k = 3;
        String s = "aabacbebebe";
        int ans = sol.longestSubstringKDistinct(s, k);
        System.out.println(ans);
    }
}