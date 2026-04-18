package BinaryTrees;
import java.util.*;

public class BFSandDFS {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void printBFS(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.remove();
            System.out.print(curr.data +" ");
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
    }

    // DFS by recursion
    // public static void printDFS(Node root){
    // if(root == null) return;

    // System.out.print(root.data + " ");
    // printDFS(root.left);
    // printDFS(root.right);
    // }

    //DFS by iteration
    public static void printDFS(Node root){
        if(root == null) return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node curr = st.pop();
            System.out.print(curr.data + " ");

            // push right first (so left is processed first)
            if(curr.right != null){
                st.push(curr.right);
            }
            if(curr.left != null){
                st.push(curr.left);
            }
        }
    }

    public static void main(String args[]){
         /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7  
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5); 
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printBFS(root);
        System.out.println();
        printDFS(root);
    }
}
