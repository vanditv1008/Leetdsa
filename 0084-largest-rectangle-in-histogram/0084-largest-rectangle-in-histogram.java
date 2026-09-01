class Solution {
    public int largestRectangleArea(int[] arr) {
         int maxarea=0;
        int[] nsr=new int[arr.length];
        int[] nsl=new int[arr.length];
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){   //suppose 5 ayya aur peek pe 6 hai toh usko remove karenge tabhi toh smaller value nikal payenge
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){   //suppose 2 aaya aur dekha 3 usse bada betha hai toh 3 ko hatena hoga na
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0;i<arr.length;i++){
            int width=nsr[i]-nsl[i]-1;
            int area=arr[i]*width;
            maxarea=Math.max(maxarea, area);
        }
        return maxarea;
    }
}