package Hashmap;
import java.util.*;

public class HashmapB {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("USA",50);
        map.put("China",150);
        map.put("India",100);
        System.out.println(map);
        
        // get
        int pop = map.get("India");
        System.out.println(pop);
        System.out.println(map.get("Indonasia"));
        
        // containsKey
        System.out.println(map.containsKey("India"));   // true
        System.out.println(map.containsKey("Indonasia"));  // false

        // remove
        map.remove("China");

        System.out.println(map.size());
        System.out.println(map.isEmpty());

        System.out.println(map);
    }
}
