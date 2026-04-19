package Hashmap;
import java.util.*;

public class majorityElement {
    public static void majority(int arr[]){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            // if(map.containsKey(a))
            //     map.put(a,map.get(a)+1);
            // else
            //     map.put(a,1);
            map.put(a,map.getOrDefault(a, 0)+1);
        }
        n= n/3;
        for(int i:map.keySet()){
            if(map.get(i)>n)
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        int arr2[] = {1, 2};

        majority(arr);
        majority(arr2);
        
    }

}
