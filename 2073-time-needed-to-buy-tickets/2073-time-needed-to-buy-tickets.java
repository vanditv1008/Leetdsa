class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
            Queue<Integer>q=new LinkedList<>();
            int ans=0;
            for(int i=0;i<tickets.length;i++){
                q.add(i);
            }
            while(!q.isEmpty() && tickets[k]>0){
                int idx=q.remove();
                tickets[idx]--;
                ans+=1;
                if(tickets[idx]>0){
                    q.add(idx);
                }
            }
            return ans;
    }
}