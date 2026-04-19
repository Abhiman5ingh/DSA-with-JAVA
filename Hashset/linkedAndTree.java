package Hashset;
import java.util.*;

public class linkedAndTree {
    public static void main(String[] args) {
        HashSet<String> cities1 = new HashSet<>();

        cities1.add("Delhi");
        cities1.add("Mumbai");
        cities1.add("Kanpur");
        cities1.add("Delhi");
        cities1.add("Noida");
        System.out.println(cities1);

        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kanpur");
        cities.add("Delhi");
        cities.add("Noida");

        System.out.println(cities);

        TreeSet<String> cities2 = new TreeSet<>();

        cities2.add("Delhi");
        cities2.add("Mumbai");
        cities2.add("Kanpur");
        cities2.add("Delhi");
        cities2.add("Noida");

        System.out.println(cities2);
    }
}
