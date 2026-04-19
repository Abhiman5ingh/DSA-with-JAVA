package Heap;

import java.util.PriorityQueue;

public class connectKRopes {
    public static void main(String[] args) {
        int ropes[] = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int r: ropes){
            pq.add(r);
        }

        int cost =0;
        while(pq.size()>1){
            int m1 = pq.remove();
            int m2 = pq.remove();
            cost += m1+m2;
            pq.add(m1+m2);
            System.out.println(pq);
        }

        System.out.println("Mininum cost: "+ cost);
    }
}
