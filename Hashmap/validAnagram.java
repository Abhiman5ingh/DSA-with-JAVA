package Hashmap;
import java.util.*;

public class validAnagram {
    public static void main(String args[]){
        // String s = "knee"; 
        // String t = "keen";
        String s = "tulip"; 
        String t = "lipid";

        HashMap<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length()){
            System.out.print("false");
            return;
        }
        // putting in hash
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        // removing from hash
        for(int i=0; i<t.length();i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }
        }

        System.out.print("Anagrams: "+map.isEmpty());
    }
}
