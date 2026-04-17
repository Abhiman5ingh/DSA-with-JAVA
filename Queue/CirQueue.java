package Queue;

public class CirQueue {
    static int arr[];
    static int size;
    static int rear;
    static int front;

    CirQueue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
        front = -1;
    }

    public static boolean isEmpty(){
        return rear == -1 && front == -1;
    
    }
    public static boolean isFull(){
        return (rear+1) % size == front;
    }

    public void add(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front == -1){
            front = 0;
        }
        rear = (rear+1) % size;
        arr[rear] = data; 
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int result = arr[front];
        if (front == rear){
            front = rear = -1;
        } else{
            front = (front+1) % size;
        }
        return result;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args){
        QueueB q = new QueueB(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}
