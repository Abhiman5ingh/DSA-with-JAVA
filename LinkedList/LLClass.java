package LinkedList;
import java.util.LinkedList;
public class LLClass {
    
    public static void main(String[] args) {
        // create
        LinkedList<Integer> list = new LinkedList<>();
        // add
        list.addLast(1);
        list.addLast(2);
        list.addFirst(0);
        System.out.println(list); // [0, 1, 2]
        // remove
        list.removeFirst();
        list.removeLast();
        System.out.println(list); // [1]

    }
}
