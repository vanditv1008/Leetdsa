class Solution {
    public int[] nextGreaterElements(int[] nums) {
    int n=nums.length;
    int[] ans=new int[n];
    Stack<Integer>s=new Stack<>();
    
    for(int i=2*n-1;i>=0;i--){
        int idx=i%n;
        while(!s.isEmpty() && nums[s.peek()]<=nums[idx]){
            s.pop();
        }
        if(s.isEmpty()){
            ans[idx]=-1;
        }else{
            ans[idx]=nums[s.peek()];
        }
        s.push(idx);
    }
    return ans;
    }
}