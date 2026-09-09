class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] col=new int[graph.length];
          for(int i=0;i<col.length;i++){
            col[i]=-1;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;//yellow color
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].length;j++){
                        int e=graph[curr][j];
                        if(col[e]==-1){
                            int nextcol=col[curr]==0?1:0;
                            col[e]=nextcol;
                            q.add(e);
                        }else if(col[e]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
 