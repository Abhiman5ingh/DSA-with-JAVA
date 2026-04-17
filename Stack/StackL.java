package Stack;
public class StackL {
    
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Stack {
        public Node head;
        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }   
            return head.data;
        }
    }

    public static void main(String args[]){
        Stack s = new Stack();
        // Stack<Integer> s = new Stack<>();  // using java's built in stack class
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
