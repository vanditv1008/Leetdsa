class Solution {
    public int[] topKFrequent(int[] nums, int k){
    HashMap<Integer,Integer>map=new HashMap<>();
    PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.comparingInt(map::get));
    for(int i=0;i<nums.length;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    }
    for(int key:map.keySet()){
        pq.add(key);
        if(pq.size()>k){
            pq.poll();
        }
    }
    int[] result=new int[k];
    for(int i=0;i<k;i++){
        result[i]=pq.poll();
    }
    return result;
    }
}