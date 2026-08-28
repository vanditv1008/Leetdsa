class Solution {
    public int totalFruit(int[] fruits) {
        int lp=0;
        int max=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int rp=0;rp<fruits.length;rp++){
            map.put(fruits[rp],map.getOrDefault(fruits[rp],0)+1);
            if(map.size()>2){
                int count=map.get(fruits[lp]);
                if(count==1){
                    map.remove(fruits[lp]);
                }else{
                    map.put(fruits[lp],count-1);
                }
                lp++;
            }
            max=Math.max(max,rp-lp+1);
        }
        return max;
    }

}