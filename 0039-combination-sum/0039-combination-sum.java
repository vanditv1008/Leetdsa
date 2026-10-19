class Solution {
    public void sum(int[] candidates,int target,List<List<Integer>>ans,List<Integer>comb,int i){
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(i==candidates.length || target<0){
            return;
        }
        comb.add(candidates[i]);
        //inclusion single
        sum(candidates,target-candidates[i],ans,comb,i);
        comb.remove(comb.size()-1);
        //exclusion
        sum(candidates,target,ans,comb,i+1);
    } 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>comb=new ArrayList<>();
        sum(candidates,target,ans,comb,0);
        return ans;
    }
}