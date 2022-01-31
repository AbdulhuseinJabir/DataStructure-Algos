import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.PriorityQueue;
import java.util.Collections; 

public class Array_kthLargestElement {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(Arrays.asList(12, 3, 5, 6, 3, 19)); 
        int k = 2;
        // System.out.println(sortingMethod(data, k));
        System.out.println(minHeapMethod(data, k));
    }

    public static int sortingMethod(List<Integer> data, int k) { //Simply sort the array using inbuilt heap sort or merge sort and return data.length - k + 1 element
        Collections.sort(data);
        return data.get(data.size() - k);
    }

    public static int minHeapMethod(List<Integer> data, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(data.subList(0,k)); // create a min-heap using PriorityQueue class and insert first k elements of the array into the heap
        System.out.println(minHeap.peek());
        for (int i = k; i < data.size(); i++) {
            if (data.get(i) > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(data.get(i));
            }
        }
        return minHeap.peek();
    }
}


