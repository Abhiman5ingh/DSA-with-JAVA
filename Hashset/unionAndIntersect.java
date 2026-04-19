package Hashset;

import java.util.HashSet;

public class unionAndIntersect {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> set = new HashSet<>();

        // UNION
        for(int a: arr1){
            set.add(a);
        }
        for(int a: arr2){
            set.add(a);
        }

        System.out.println("union: " +set.size());
        set.clear();

        //INTERSECTION
        for(int a: arr1){
            set.add(a);
        }
        int count =0 ;
        for(int i: arr2){
            if(set.contains(i)){
                count++;
                set.remove(i);
            }
        }

        System.out.println("intersecton: "+ count);
    }
}
