class Solution {
    public void sum(int[] candidates, int target, List<List<Integer>>ans,ArrayList<Integer>comb,int i){
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(i==candidates.length || target<0){
            return;
        }
        comb.add(candidates[i]);
        sum(candidates,target-candidates[i],ans,comb,i+1);
        comb.remove(comb.size() - 1);
        int next=i+1;
        while(next<candidates.length && candidates[next]==candidates[i]){
            next++;
        }
        sum(candidates,target,ans,comb,next);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>comb=new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates,target,ans,comb,0);
        return ans;
    }
}