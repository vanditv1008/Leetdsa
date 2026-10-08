class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxvalue=0;
        for(int val:map.values()){
            maxvalue=Math.max(val,maxvalue);
        }
        int ans=0;
        for(int i:map.values()){
            if(i==maxvalue){
                ans+=maxvalue;
            }
        }
        return ans;
    }
}