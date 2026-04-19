package Hashmap;
import java.util.*;

import java.util.HashMap;

public class iterateOnHasMap {
    public static void main(String args[]){
         HashMap<String, Integer> map = new HashMap<>();

        map.put("USA",50);
        map.put("China",150);
        map.put("India",100);
        map.put("Indonesia",6);
        map.put("Nepal",5);

        //  iterate
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key = "+k+" ,value = "+map.get(k));
        }
    }
}
