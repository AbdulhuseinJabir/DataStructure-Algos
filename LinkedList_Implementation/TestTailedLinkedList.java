package LinkedList_Implementation;

import java.util.*;

public class TestTailedLinkedList {
	public static void main(String [] args) {
		TailedLinkedList list = new TailedLinkedList();

		list.addFront(1);
		list.addFront(2);
		list.addFront(3);
		list.addBack(4);
		list.addAtIndex(2,5);
		list.print();

		System.out.println("Testing removal");
		list.removeFront();
		list.removeBack();
		list.removeAtIndex(1);
		list.print();

		if (list.contains(1)) 
			list.addFront(6);
		list.print();
	}
}
