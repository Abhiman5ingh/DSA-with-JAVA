package DivideAndConquer;
public class Quicksort{
    public static void sort(int arr[], int si, int ei){
        if(si >= ei) return;
        int pidx= partition(arr, si, ei);
        sort(arr, si, pidx-1);
        sort(arr, pidx+1, ei);
    }
    public static int partition(int arr[], int si, int ei){
        int pivot=arr[ei];
        int i=si-1;
        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                int temp= arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int t= arr[ei];
        arr[ei]=arr[i];
        arr[i]=t;
        return i;
    }
    public static void main(String args[]){
        int arr[]={2,5,9,4,17,87,34,25,90,44,71,31,11,109};
        int l=arr.length;
        sort(arr, 0 ,l-1);
        for(int a: arr){
            System.out.print(a+" ");
        }
    }
}