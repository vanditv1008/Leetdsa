class Solution {
    public void Divide(int[] nums,int s,int e){
        if(s>=e){
            return;
        }
        int mid=s+(e-s)/2;
        Divide(nums,s,mid);
        Divide(nums,mid+1,e);
        Conquer(nums,s,mid,e);
    }
    public void Conquer(int[] nums,int s,int mid,int e){
        int[] temp=new int[e-s+1];
        int i=s;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=e){
            if(nums[i]<nums[j]){
                temp[k]=nums[i];
                i++;
            }else{
                temp[k]=nums[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k]=nums[i];
            i++;
            k++;
        }
        while(j<=e){
            temp[k]=nums[j];
            j++;
            k++;
        }
        for( k=0,i=s;k<temp.length;k++,i++){
            nums[i]=temp[k];
        }
    }
    public int[] sortArray(int[] nums) {
        int s=0;
        int e=nums.length-1;
        Divide(nums,0,nums.length-1);
        return nums;


    }
}