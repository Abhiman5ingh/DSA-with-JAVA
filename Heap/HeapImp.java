package Heap;
import java.util.ArrayList;

public class HeapImp {

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data){  //O(logn)
        arr.add(data);

        int x = arr.size() - 1;     // child index 
        
        while(x > 0){   //O(logn) -> worst
            int par =  (x - 1)/2; 
            if(arr.get(x) < arr.get(par)){     // parent index
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x= par;
            } else {
                break;
            }
        }
    }

    public int peek(){
        return arr.get(0);
    }

    private void heapify(int idx){
        int left = 2*idx + 1; 
        int right = 2*idx + 2; 
        int min = idx;

        if(left < arr.size() && arr.get(left) < arr.get(min)){
            min = left;
        }
        if(right < arr.size() && arr.get(right) < arr.get(min)){
            min = right;
        }
        if(min != idx){
            //swap
            int temp = arr.get(idx);
            arr.set(idx, arr.get(min));
            arr.set(min, temp);

            heapify(min);
        }
    }

    public int remove(){
        int data = arr.get(0);

        // swap
        int temp = arr.get(0);
        arr.set(0,arr.get(arr.size() -1));
        arr.set(arr.size() -1, temp);

        // remove last
        arr.remove(arr.size() - 1);

        // heapify
        heapify(0); // call for root
        return data;
    }

    public boolean isEmpty(){
        return arr.size() == 0;
    }
}

    public static void main(String args[]){
        Heap hp = new Heap();
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        hp.add(1);

        System.out.println(hp.peek());
        System.out.println(hp.remove());
        System.out.println(hp.peek());
        
    }
}
