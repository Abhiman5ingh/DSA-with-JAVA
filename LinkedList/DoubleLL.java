package LinkedList;
public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;
    
    public Node(int data){
        this.data= data;
        this.next = null;
        this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public int size;

    public void addfirst(int data){
        Node newNode = new Node (data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("System Underflow");
            return Integer.MIN_VALUE;
        } 

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;;
        size--;
        head.prev = null;
        return val;
    }
    
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);

        dll.print();
        System.out.println("Size: " + dll.size);
        // dll.removeFirst();
        dll.reverse();
        dll.print();
    }
}
