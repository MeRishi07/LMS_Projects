package LMS_Projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static List<Integer> findLongestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        List<Integer> longestIncreasingSubsequence = new ArrayList<>();
        while (endIndex != -1) {
            longestIncreasingSubsequence.add(0, nums[endIndex]);
            endIndex = prev[endIndex];
        }

        return longestIncreasingSubsequence;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        List<Integer> lis = findLongestIncreasingSubsequence(nums);

        System.out.println("Longest Increasing Subsequence: " + lis);
    }
}
