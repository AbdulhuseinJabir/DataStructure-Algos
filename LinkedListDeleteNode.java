// you can delete a node in 2 ways

// if you want to delete a node that you have cuurently then just do node->val=node->next->val and node->next=node->next->next (you simply made the current node as the next node !)
// the above way won't work if you have the last node and want to delete it, in that case just get the node before it and do that node->next=node->next->next.


public class LinkedListDeleteNode {
    static class Node {
        int value;
        Node next = null;

        Node (int data) {
            this.value = data;
        }

        Node (int data, Node next) {
            this.value = data;
            this.next = next;
        }
        
        int getVal() {
            return value;
        }

        void setVal(int newValue) {
            this.value = newValue;
        }
    }

    static class LinkedList {
        static Node head;

        LinkedList (Node h) {
            this.head = h;
        }

        void add (Node newNode) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        void removeSpecificNode (Node toRemove) { //Basically set your value to the next node value and then by pass the next node.
            toRemove.setVal(toRemove.next.getVal());
            toRemove.next = toRemove.next.next;
        }

        void print() {
            Node current = head;
            while (current != null) {
                System.out.print(current.getVal());
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        LinkedList ll = new LinkedList(new Node(4));
        ll.add(new Node(5));
        ll.add(new Node(1));
        ll.add(new Node(9));

        Node givenPointer = ll.head.next; 

        ll.removeSpecificNode(givenPointer);

        ll.print();

    }

}
