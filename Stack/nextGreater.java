package Stack;
import java.util.*;

public class nextGreater {
    public static void main(String args[]){
        int arr[] = {6, 8, 0 , 1, 3};
        int n = arr.length;
        int nextGreat[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i= n-1;i>=0;i--){
            // while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            // if-else
            if(s.isEmpty()){
                nextGreat[i] = -1;
            } else {
                nextGreat[i] = arr[s.peek()];
            }
            // push
            s.push(i);
        }
        for(int i=0; i<n; i++){
            System.out.print(nextGreat[i] + ", ");
        }
    }
}
