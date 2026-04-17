package LinkedList;
public class LinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;     
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){ 
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        } else if(size ==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size ==0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size ==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        // prev = size-2
        for(int i=0;i < size -2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(int key, Node temp){
        if(temp == null)
            return -1;
        if(temp.data == key)
            return 0;
        int idx = helper(key, temp.next);
        if(idx == -1)
            return -1;
        return idx+1;
    }

    public int recSearch(int key){
        return helper(key, head);
    }

    // public int recSearch(int key, Node temp, int i){
    //     if(temp == null)
    //         return -1;
    //     if(temp.data == key)
    //         return i;
    //     return recSearch(key, temp.next, i++);
    // }

    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; 
    }

    public void deleteNthFromEnd(int n){
        Node prev = head;
        // calculate size
        int size =0;
        while(prev != null){
            size++;
            prev = prev.next;
        }
        if(n == size){
            head = head.next; // remove first node
            return;
        }
        
        int i =1;
        int iToFind = size - n;
        prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMiddle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;    // Middle Node
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node mid = findMiddle();
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr  = next;
        }
        Node right = prev; // head of right half
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle(){  // Floyd's CFA
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        Node slow = head;
        Node fast = head.next;
        int exists = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                exists = 1;
                break;
            }
        }
        if(exists == 0){
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null; // to remove cycle
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null; // remove cycle
    }

    public Node merge(Node head1, Node head2){
        Node merged = new Node(-1);
        Node temp = merged;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
     }

    public Node mergeSort(Node head){
        if( head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newleft = mergeSort(head);
        Node newright = mergeSort(rightHead);
        // merge
        return merge(newleft, newright);
    }

    public void zigzag(){
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node Lnext, Rnext;

        while(left != null && right != null){
            Lnext = left.next;
            left.next = right;
            
            Rnext = right.next;
            right.next = Lnext;

            left = Lnext;
            right = Rnext;
        }
    }

    public static void main(String args[]){
        // LinkedList list = new LinkedList();
        // list.addFirst(2);
        // list.addFirst(1);
        // list.addLast(5);
        // list.addLast(6);
        // list.add(2,3);
        // list.add(3,4);
        // list.removeFirst();
        // list.removeLast();
        // list.print();
        // System.out.println(list.recSearch(5));
        // System.out.println(size);
        // list.reverse();
        // list.addLast(2);
        // list.addLast(1);
        // list.deleteNthFromEnd(3);
        // list.print();
        // System.out.println(list.checkPalindrome());

        // Create a cycle for testing
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp; // creates a cycle
        // // 1 -> 2 -> 3 -> 1 ...
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());
    
        // for merge of LL
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        // LinkedList.head = ll.mergeSort(LinkedList.head);
        ll.zigzag();
        ll.print();
    }
}