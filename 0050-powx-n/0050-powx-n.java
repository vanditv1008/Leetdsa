class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
       return power(x,N);
    }
    public static double power(double x,long N){
        if(N==0){
            return 1;
        }
        double half=power(x, (int)(N / 2));
        double hps=half*half;
        
        if(N%2!=0){
            hps=hps*x;
        }
        return hps;
    }
}