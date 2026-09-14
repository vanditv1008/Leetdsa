class Solution {
    public List<Integer> findLonely(int[] nums) {
      ArrayList<Integer>ans=new ArrayList<>();
      Arrays.sort(nums);
      for(int i=0;i<nums.length;i++){
        int curr=nums[i];
        if((i>0 && curr==nums[i-1]) || (i>0 && nums[i-1]==curr-1)){
            continue;
        }
        if((i<nums.length-1 && curr==nums[i+1]) || (i<nums.length-1 && nums[i+1]==curr+1)){
            continue;
        }
        ans.add(curr);
      }  
      return ans;
    }
}