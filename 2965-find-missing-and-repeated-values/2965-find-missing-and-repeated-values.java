class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int expsum=0;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                expsum+=grid[i][j];
                if(set.contains(grid[i][j])){
                        a=grid[i][j];
                }else{
                     set.add(grid[i][j]);
                
                }
            }
        }
        int n=grid.length*grid.length;
        int expectedsum=n*(n+1)/2;
        b=expectedsum-expsum+a;
        int[] arr={a,b};
        return arr;
        }
}