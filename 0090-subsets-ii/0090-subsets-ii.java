class Solution {
    public void sub(int[] nums,List<List<Integer>>ans,List<Integer>curr,int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        sub(nums,ans,curr,i+1);
        curr.remove(curr.size()-1);
        int idx=i+1;
        while(idx<nums.length && nums[idx]==nums[idx-1]){
            idx++;
        }
        sub(nums,ans,curr,idx);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        Arrays.sort(nums);
        sub(nums,ans,curr,0);
        return ans;
    }
}