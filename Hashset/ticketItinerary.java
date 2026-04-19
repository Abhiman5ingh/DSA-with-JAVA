package Hashset;

import java.util.HashMap;

public class ticketItinerary {

    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> ticketRev = new HashMap<>();
        for(String s: tickets.keySet()){
            ticketRev.put(tickets.get(s), s);
        }

        for(String s: tickets.keySet()){
            if(!ticketRev.containsKey(s)){
                return s;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);

        System.out.print(start);
        while(tickets.containsKey(start)){
            System.out.print(" -> "+ tickets.get(start));
            start = tickets.get(start);
        }

    }
}
