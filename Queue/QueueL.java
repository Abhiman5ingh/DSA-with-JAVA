package Queue;

public class QueueL {
    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
        public static Node head = null;
        public static Node tail = null;

        public void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
            } else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        public int remove(){
            if(head == null){
                System.out.println("Queue is empty");
                return -1;
            }
            int result = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
            return result;
        }

        public int peek(){
            if(head == null){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }

        public static void main(String[] args){
            QueueL q = new QueueL();
            q.add(1);
            q.add(2);
            q.add(3);
            System.out.println(q.peek());
            System.out.println(q.remove());
            System.out.println(q.peek());
        }
}
