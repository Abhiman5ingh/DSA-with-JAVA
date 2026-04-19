package Hashmap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class linkedHash {
    
    public static void main(String[] args) {
        // Store the key in the order they are put in the hash
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        System.out.println(lhm);

        // Sort the key stored in the hash
        TreeMap <String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);

        System.out.println(tm);
    }
}
