package Hashset;
import java.util.*;

public class hashsetImp {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(5);
        set.add(8);
        set.add(2);

        System.out.println(set);
        System.out.println(set.contains(2));
        System.out.println(set.contains(3));
        
        set.remove(2);
        System.out.println(set);
        
        set.clear();
        System.out.println(set.isEmpty());
        
    }
}
