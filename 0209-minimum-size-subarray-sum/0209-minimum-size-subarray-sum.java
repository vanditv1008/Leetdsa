class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int lp=0;
        int sum=0;
        for(int rp=0;rp<nums.length;rp++){
            sum+=nums[rp];
            while(sum>=target){
                min=Math.min(min,rp-lp+1);
                sum-=nums[lp];
                lp++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }else{
            return min;
        }
    }
}