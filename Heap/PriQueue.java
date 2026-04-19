package Heap;
import java.util.*;

public class PriQueue {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  // for reverse order

        pq.add(new Student("A",3));
        pq.add(new Student("C",5));
        pq.add(new Student("D",2));
        pq.add(new Student("B",22));
        // pq.add(7);
        // pq.add(1);
        // pq.add(5);

        while(!pq.isEmpty()){
            // System.out.print(pq.peek()+" ");
            System.out.println(pq.peek().name+"-->"+pq.peek().rank);
            pq.remove();
        }
    }
}
