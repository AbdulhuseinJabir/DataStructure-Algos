import java.util.*;

public class validSudoku {
    public static void main(String[] args) {
        char[][] data =     {{'5','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}};
        // char[][] rows = new char[9][9];
        // System.out.println(Arrays.deepToString(rows));
        // System.out.println(rows[0][0] == '\0');
        System.out.println(isValidSudoku(data));
        
    }
    
    public static boolean isValidSudoku(char[][] board) {
        char[][] rows = new char[9][9];
        char[][] cols = new char[9][9];
        char[][] boxes = new char[9][9];

        // System.out.println(Arrays.deepToString(rows));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int value = Character.getNumericValue(board[i][j]) - 1;
                    
                    if (rows[i][value] == '\0')
                        rows[i][value] = '1';
                    else 
                        return false;
                    
                    if (cols[j][value] == '\0')
                        cols[j][value] = '1';
                    else 
                        return false;
                    
                    int boxID = ((int) (i / 3) * 3) + (int) (j / 3);
                    if (boxes[boxID][value] == '\0')
                        boxes[boxID][value] = '1';
                    else 
                        return false;
                }
            }
        }
        return true;
    }
}


class recursion { 
    static Node head; // head of list 
     
    static class Node { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
 
    static Node reverse(Node head) 
    { 
        if (head == null || head.next == null) 
            return head; 
 
        /* reverse the rest list and put 
        the first element at the end */
        Node rest = reverse(head.next); 
        head.next.next = head; 
 
        /* tricky step -- see the diagram */
        head.next = null; 
 
        /* fix the head pointer */
        return rest; 
    } 
 
    /* Function to print linked list */
    static void print() 
    { 
        Node temp = head; 
        while (temp != null) { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
        System.out.println();
    } 
 
    static void push(int data) 
    { 
        Node temp = new Node(data); 
        temp.next = head; 
        head = temp; 
    } 
  