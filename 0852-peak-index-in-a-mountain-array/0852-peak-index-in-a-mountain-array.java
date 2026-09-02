class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lp=0;
        int rp=arr.length-1;
        while(lp<rp){
            int mid=lp+(rp-lp)/2;
            if(arr[mid]<arr[mid+1]){
                lp=mid+1;
            }else{
                rp=mid;
            }
        }
return lp;
    }
}