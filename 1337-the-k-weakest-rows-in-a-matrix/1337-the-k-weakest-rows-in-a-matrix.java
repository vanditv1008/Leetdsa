class Solution {
    static class Row implements Comparable<Row>{
        int sold;
        int idx;
        public Row(int sold, int idx) {
            this.sold = sold;
            this.idx = idx;
        }
        public int compareTo(Row r2){
            if(this.sold==r2.sold){
                return  Integer.compare(this.idx,r2.idx);
            }else{
                return Integer.compare(this.sold,r2.sold);
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
     PriorityQueue<Row>pq=new PriorityQueue<>();
     for(int i=0;i<mat.length;i++){
        int count=0;
        for(int j=0;j<mat[0].length;j++){
            count+=mat[i][j]==1?1:0;
        }
        pq.add(new Row(count,i));
     }   
     int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().idx;
        }
        return result;
    }
}