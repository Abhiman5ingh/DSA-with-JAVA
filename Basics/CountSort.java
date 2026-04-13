package Basics;
public class CountSort{
    public static void CSort(int arr[]){
        int max=0;
        int l=arr.length;
        for(int i=0;i<l;i++){
            max=Math.max(max,arr[i]);
        }
        int count[]= new int[max+1];
        for(int n:arr){
            count[n]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]!=0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,4,3,2,3,4,2};
        CSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}