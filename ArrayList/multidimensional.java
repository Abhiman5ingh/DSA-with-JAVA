package ArrayList;
import java.util.*;

public class multidimensional {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(4);
        l2.add(6);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(3);
        l3.add(5);
        mainlist.add(l1);
        mainlist.add(l2);
        mainlist.add(l3);

        // printing the list
        System.out.print(mainlist);
    }
}
