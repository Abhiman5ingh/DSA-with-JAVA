package BST;

public class sortedArrToBST {
    public class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node sortedToBST(int[] arr, int st, int end){
        if(st > end) return null;

        int mid = (st + end) / 2;
        Node root = new sortedArrToBST(). new Node(arr[mid]);

        root.left = sortedToBST(arr, st, mid -1);
        root.right = sortedToBST(arr, mid+1, end);

        return root;
    }

    public static void main(String args[]){
        int values[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = sortedToBST(values, 0, values.length - 1);

        /*      8
              /   \
             5     11
            / \    / \
           3   6  10  12
         */

        preOrder(root);
    }
}
