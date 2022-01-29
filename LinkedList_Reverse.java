public class LinkedList_Reverse {
    public static void main(String[] args) {

        LinkedList mylist = new LinkedList(new Node(1));
        mylist.add(new Node(2));
        mylist.add(new Node(3));
        mylist.add(new Node(4));
        mylist.add(new Node(5));

        mylist.print();
        mylist.reverseLinkedList();
        // mylist.reverseLinkedListRecursion();
        mylist.print();

    }
}

class Node {
    int value;
    Node next;
    Node (int data) {
        this(data, null);
    }
    Node (int data, Node n) {
        this.value = data;
        this.next = n; 
    }
}

class LinkedList {
    static Node head;

    LinkedList(Node head) {
        LinkedList.head = head;
    }

    void add (Node newNode) {
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }
    
    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    void reverseLinkedList() { // The implementation through normal switching.
        Node previous = null;
        Node current = head;
        Node next = null;   

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous; // This is to ensure our newHead is the last element.
    }
    
    void reverseLinkedListRecursion() {
        head = mainRecursiveCode(head);
    }

    Node mainRecursiveCode(Node current) { // This implementation is a recursive approach.
        if (current.next == null) { // The moment we hit the last value in our linked list, we return it. 
            return current;
        }
        
        Node remaining = mainRecursiveCode(current.next); // Intially here we will get our last value.
        current.next.next = current; // The current when we have the last value as remaining will be the secondlast value. 
                                     // Hence we need to first go to our current.next (which is out last value) and change its next to the current. 
        current.next = null; // This keeps making the current node.next null so that when we hit the our first value, we will set its next to null. 
        return remaining; 
    }
}
