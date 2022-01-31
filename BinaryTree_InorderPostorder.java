// import java.util.*;

// /**
//  * BinaryTreeInorderPostorder
//  */
// public class BinaryTreeInorderPostorder {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int num = sc.nextInt();
//         ArrayList<Integer> inot = new ArrayList<>();
//         ArrayList<Integer> post = new ArrayList<>();
//         for (int i=0; i < num; i++) {
//             inot.add(sc.nextInt());
//         }
//         for (int i=0; i < num; i++) {
//             post.add(sc.nextInt());
//         }

//         System.out.println(inot);
//         System.out.println(post);



//     }
// }

// Java program to print Postorder traversal from given
// Inorder and Preorder traversals.
import java.util.Stack;
import java.util.*;
 
public class BinaryTree_InorderPostorder {
 
    static int postIndex;
 
    // Fills preorder traversal of tree with given
    // inorder and postorder traversals in a stack
    void fillPre(int[] in, int[] post, int inStrt,
                 int inEnd, Stack<Integer> s)
    {
        if (inStrt > inEnd)
            return;
 
        // Find index of next item in postorder traversal in
        // inorder.
        int val = post[postIndex];
        int inIndex = search(in, val);
        postIndex--;
 
        // traverse right tree
        fillPre(in, post, inIndex + 1, inEnd, s);
 
        // traverse left tree
        fillPre(in, post, inStrt, inIndex - 1, s);
        
        // Scanner sc = new Scanner(System.in);
        // sc.next();
        System.out.println(val);
        s.push(val);
    }
 
    // This function basically initializes postIndex
    // as last element index, then fills stack with
    // reverse preorder traversal using printPre
    void printPreMain(int[] in, int[] post)
    {
        int len = in.length;
        postIndex = len - 1;
        Stack<Integer> s = new Stack<Integer>();
        fillPre(in, post, 0, len - 1, s);
        while (s.empty() == false)
            System.out.print(s.pop() + " ");
    }
 
    // A utility function to search data in in[]
    int search(int[] in, int data)
    {
        int i = 0;
        for (i = 0; i < in.length; i++)
            if (in[i] == data)
                return i;
        return i;
    }
 
    // Driver code
    public static void main(String ars[])
    {
        int in[] = {4, 2, 5, 1, 3, 6};
        int post[] = {4, 5, 2, 6, 3, 1};
        BinaryTree_InorderPostorder tree = new BinaryTree_InorderPostorder();
        tree.printPreMain(in, post);
    }
}