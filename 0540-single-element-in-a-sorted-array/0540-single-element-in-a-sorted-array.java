class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lp=0;
        int rp=nums.length-1;
        
        while(lp<rp){
        int mid=lp+(rp-lp)/2;
        if(mid%2==1){
            mid--;
        }
        if(nums[mid]==nums[mid+1]){
            lp=mid+2;
        }else{
            rp=mid;
        }

        }
        return nums[lp];
    }
}