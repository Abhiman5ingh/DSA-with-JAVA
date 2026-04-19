package Hashset;
import java.util.*;
public class countDistinct {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> set = new HashSet<>();
        for(int a: arr){
            set.add(a);
        }

        System.out.println("Number of distinct elements: "+ set.size());
    }
}
