package BinaryTrees;

public class Diameter1 {
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

    public static int diameter2(Node root){
        if (root == null){
            return 0;
        }

        int leftDia = diameter2(root.left);
        int leftHi = height(root.left);
        int rightDia = diameter2(root.right);
        int rightHi = height(root.right);

        int selfDia = leftHi + rightHi + 1;

        return Math.max(selfDia, Math.max(leftDia, rightDia));
    }

    static class Info{
        int dia;
        int ht;
        public Info(int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root){ // O(n)
        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.dia, rightInfo.dia));
        int ht = Math.max(leftInfo.ht, rightInfo.ht) +1;

        return new Info(diam, ht);
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

        Info info = diameter(root);

        System.out.println("Maximum diameter of the tree: " + info.dia);
        System.out.println("Maximum height of the tree: " + info.ht);
    }
}