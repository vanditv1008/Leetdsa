class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr=new int[nums.length-k+1];
        int idx=0;
        Deque<Integer>dq=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){//window se hi bahar hai
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                arr[idx]=nums[dq.peekFirst()];
                idx++;
            }
            
        }
        return arr;
    }
}