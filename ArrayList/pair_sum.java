package ArrayList;
import java.util.ArrayList;

public class pair_sum {

    // Brute Force     // O(n^2) -> all possible pairs
    public static boolean pair(ArrayList<Integer> list, int target){
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    // 2 pointer // O(n)
    public static boolean pair(ArrayList<Integer> list, int target, int i, int j){
        while(i<j){
            if(list.get(i)+list.get(j)==target) 
                return true;
            else if(list.get(i)+list.get(j) < target) 
                i++;
            else 
                j--;
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);    
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        System.out.println(pair(list,target,0,5));
    }
}
