class Solution {
    static class point implements Comparable<point>{
        int x;
        int y;
        int distsq;
        public point(int x, int y, int distsq){
        this.x=x;
            this.y=y;
            this.distsq=distsq;
        }
        @Override
        public int compareTo(point p2){
            return Integer.compare(this.distsq, p2.distsq);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<point>pq=new PriorityQueue<>();
       for (int i = 0; i < points.length; i++) {
            int distsq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new point(points[i][0], points[i][1], distsq));
        }
        int results[][]=new int[k][2];
        for(int i=0;i<k;i++){
            point current=pq.poll();
            results[i][0]=current.x;
            results[i][1]=current.y;
        }
        return results;
    }
}