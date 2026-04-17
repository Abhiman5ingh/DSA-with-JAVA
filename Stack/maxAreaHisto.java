package Stack;
import java.util.*;

public class maxAreaHisto {
    public static int maxArea(int arr[]){
        int n= arr.length;

        // Next Smaller Left 
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        // Next Smaller Right
        st = new Stack<>();
        for(int i = n-1; i >=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        // Calculate Area
        for(int i=0; i<n; i++){
            int width = nsr[i] - nsl[i] -1;
            int height = arr[i];
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static void main(String args[]){
        int arr[] = {2,1,5,6,2,3};
        System.out.println("Max area of the histogram: "+maxArea(arr));
    }
}
