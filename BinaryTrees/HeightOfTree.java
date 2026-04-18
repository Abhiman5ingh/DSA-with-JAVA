package BinaryTrees;
// import java.util.*;

public class HeightOfTree {
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

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lth = height(root.left);
        int rth = height(root.right);
        int height = Math.max(lth,rth) + 1;
        return height;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int lth = countNodes(root.left);
        int rth = countNodes(root.right);
        return lth + rth + 1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int lth = sumOfNodes(root.left);
        int rth = sumOfNodes(root.right);
        return lth + rth + root.data;
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

        System.out.println("Height of the tree: " + height(root));
        System.out.println("Number of nodes in the tree: " + countNodes(root));
        System.out.println("Sum of nodes in the tree: " + sumOfNodes(root));
    }
}
