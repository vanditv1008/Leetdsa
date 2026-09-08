class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
                if(set.contains(nums[i])){
                    ans=nums[i];
                    break;
                }
            set.add(nums[i]);
        
        }
        return ans;
    }
}