package ArrayList;
import java.util.*;

public class basic{
    public static void main(String args[]){
        // JAVA Collections Frameworks
        ArrayList<Integer> list = new ArrayList<>();
        // ADD Operation
        list.add(1);    // O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(1, 9);  // O(n) : adding at a specific index.
        System.out.println(list);

        // GET Operation
        int ele = list.get(2);  // O(1)
        System.out.println("Element at indes 2: "+ ele);

        // Delete
        list.remove(2);     // O(n)
        System.out.println(list);

        // Set
        list.set(2, 10);  // O(n): Change the element at the index
        System.out.println(list);

        // Contains
        System.out.println(list.contains(1));   // O(n)
        System.out.println(list.contains(11));
        
        // Size
        System.out.println(list.size());

        // printing the arraylist
        for(int i=0; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}