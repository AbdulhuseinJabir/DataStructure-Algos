import java.util.*;


public class LinkedListRemoveNthNodeFromEnd {
    public static void main (String[] args) {
        LinkedList ll = new LinkedList(new Node(1));
        ll.add(new Node(2));
        ll.add(new Node(3));
        ll.add(new Node(4));
        ll.add(new Node(5));
        ll.add(new Node(6));

        int posFromTail = 2; //Remove 2nd last position node from the tail 

        ll.print();
        ll.remove(posFromTail); 
        ll.print();
    }
}

class Node {
    int value;
    Node next = null;

    Node (int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

class LinkedList {
    
    static Node head;

    LinkedList (Node Node) {
        LinkedList.head = Node;
    }

    void add (Node newNode) {
        Node current = head;
        while (current.next != null) {
            current = current.next; 
        } 
        current.next = newNode;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();        
    }

    void removeNode (Node nodeR) {
        nodeR.value = nodeR.next.value;
        nodeR.next = nodeR.next.next;
    }

    void remove(int posFromTail) {
        Node[] NodeList = new Node[30];
        Node current = head;
        int pointer = 0;
        while (current != null) {
            NodeList[pointer] = current;
            current = current.next;
            pointer++;
        } // pointer here will give you size of LinkedList

        if (head.next == null) //Handle edgecase -> only head in LL 
            head = null;
        else if (posFromTail == 1) //Handle edgecase -> remove tail from LL
            NodeList[pointer - posFromTail - 1].next = null;
        else
            removeNode(NodeList[pointer - posFromTail]); 

        // System.out.println(Arrays.toString(NodeList)); This is how your print an Object Array

    }
}