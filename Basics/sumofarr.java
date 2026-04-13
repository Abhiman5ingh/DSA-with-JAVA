package Basics;
public class sumofarr{
    public static void main(String args[]){
        //int arr[]={2,-1,4,8,-2,5};
        int max=Integer.MIN_VALUE;
        int curSum=0;

        /*//BRUTE FORCE
        for(int i=0;i<6;i++){
            for(int j=i;j<6;j++){
                for(int k=i;k<=j;k++){
                    curSum+=arr[k];
                } 
                if(curSum>max) max=curSum;
            }
        }
        */

        /*// PREFIX SUM METHOD
        int presum[]=new int[6];
        presum[0]=arr[0];
        // Cal. PrefixSum
        for(int i=1;i<6;i++){
            presum[i]=arr[i]+presum[i-1];
        }
        for(int i=0;i<6;i++){
            for(int j=i;j<6;j++){
                curSum= i==0 ?presum[j]:presum[j]-presum[i-1];
                if(curSum>max) max=curSum;
            }
        }
        */

        // 3. KADANE's ALGO
        int a[]={-2,-3,4,-1,-2,1,5,-3};
        for(int i=0;i<a.length;i++){
            curSum+=a[i];
            if(curSum<0) curSum=0;
            max=Math.max(curSum,max);
        }
        System.out.println("MAX SUM: "+max);
    }
}