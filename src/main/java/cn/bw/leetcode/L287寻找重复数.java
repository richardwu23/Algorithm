package cn.bw.leetcode;

public class L287寻找重复数 {

    public int findDuplicate(int[] nums) {
        int len=nums.length;

        int left=1,right=len-1;

        while (left<right){
            int mid = (left+right)>>1;
            int count=0;
            for(int i:nums){
                if(i<=mid){
                    count++;
                }
            }
            if(count>mid){
                right = mid;
            }else {
                left=mid+1;
            }

        }
        return left;
    }
}
