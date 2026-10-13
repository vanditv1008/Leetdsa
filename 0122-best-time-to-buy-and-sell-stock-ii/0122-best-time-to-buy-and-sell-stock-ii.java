class Solution {
    public int maxProfit(int[] prices) {
      int ans=0;
      int min=prices[0];
      for(int i=1;i<prices.length;i++){
        if(prices[i]<min){
            min=prices[i];
        }else{
            int curr=prices[i]-min;
            ans+=curr;
            min=prices[i];
        }
      }  
      return ans;
    }
}