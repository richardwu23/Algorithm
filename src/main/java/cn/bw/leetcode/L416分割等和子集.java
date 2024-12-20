package cn.bw.leetcode;

public class L416分割等和子集 {

    /**
     * DP 和背包问题类似
     * dp[i] 表示是否可以通过数组中的若干元素凑出和为 i 的子集
     */

    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i:nums){
            sum+=i;
        }
        if((sum&1)==1)return false;
        int half = sum>>1;

        boolean[] dp = new boolean[half+1];
        dp[0]=true;

        for(int num:nums){
            for(int i=half;i>=num;i--){
                dp[i]=dp[i]||dp[i-num];
            }
        }
        return dp[half];


    }
}
