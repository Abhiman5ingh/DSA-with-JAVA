package DivideAndConquer;
public class Mergesort{
    public static void sort(int arr[], int si, int ei){
        if(si>=ei) return;
        int mid= (si+ei)/2;
        sort(arr,si,mid);
        sort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[]=new int[ei-si+1];
        int i=si, j=mid+1, k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
                temp[k++]=arr[i++];
        }
        while(j<=ei){
                temp[k++]=arr[j++];
        }
        for(i=si, k=0; k<temp.length; k++, i++){
            arr[i]=temp[k];
        }
    }
    public static void main(String args[]){
        int arr[]={1,5,4,9,3,8,54,32,12,98,23,45,72,11};
        int l=arr.length-1;
        sort(arr,0,l);
        for(int i=0; i<l; i++){
            System.out.print(arr[i]+" ");
        }
    }
}