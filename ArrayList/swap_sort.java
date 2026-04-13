package ArrayList;
import java.util.*;

public class swap_sort {
    public static void swapping(ArrayList<Integer> list, int idx1, int idx2){
        int a= list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,a);
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);    
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        
        int idx1=1, idx2=3;
        swapping(list ,idx1, idx2);
        System.out.println(list);
        
        // Sorting 
        Collections.sort(list);
        System.out.println(list);
        
        Collections.sort(list, Collections.reverseOrder());
        // Comparator - fnx
        System.out.println(list);

    }
}
