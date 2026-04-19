package Hashset;

import java.util.HashSet;
import java.util.Iterator;

public class iterateSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kanpur");
        cities.add("Delhi");
        cities.add("Noida");

        Iterator it = cities.iterator();
        // will not in order
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
