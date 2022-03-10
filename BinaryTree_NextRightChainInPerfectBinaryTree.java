/*
Populating Next Right Pointers in Each Node
You are given a perfect binary tree where all leaves are on the same level, 
and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next 
right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

*/


class BinaryTree_NextRightChainInPerfectBinaryTree {
    public static void main (String[] args) {
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node root = new Node(1, node2, node3, null);
        node2.left = new Node(4);
        node2.right = new Node(5); 
        node3.left = new Node(6);
        node3.right = new Node(7); 

        connectRightNodes(root);

        printConnectedNodes(root);
    }

    static void connectRightNodes(Node parent) {
        if (parent == null) {
            return;
        }
        
        if (parent.left != null && parent.right != null) {
            parent.left.next = parent.right;
        }

        if (parent.next != null && parent.next.left != null) {
            parent.right.next = parent.next.left;
        }

        connectRightNodes(parent.left);
        connectRightNodes(parent.right);

        return;

    }

    static void printConnectedNodes(Node root) {
        while (root != null) {
            Node curr = root;
            while (curr != null) {
                System.out.print(curr.val);
                curr = curr.next;
            }
            System.out.println("#");
            root = root.left;
        }
    }
} 

class Node {
    public int val;
    public Node left = null;
    public Node right = null;
    public Node next = null;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};