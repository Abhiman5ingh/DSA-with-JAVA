package BinaryTrees;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeB {
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
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]); // root
            newNode.left = buildTree(nodes);    // left sub tree
            newNode.right = buildTree(nodes);   // right sub tree

            return newNode;
        }

        public static void preOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }

            }
        }
    }
    public static void main(String args[]){
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.buildTree(nodes);
        System.out.println(root.data);
        // System.out.println("Preorder traversal is: ");
        // BinaryTree.preOrder(root);
        // System.out.println("\nPostorder traversal is: ");
        // BinaryTree.postOrder(root);
        // System.out.println("\nInorder traversal is: ");
        // BinaryTree.inOrder(root);
        System.out.println("\nLevel order traversal is: ");
        BinaryTree.levelOrder(root);
    }
}
