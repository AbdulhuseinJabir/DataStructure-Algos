import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

class Sorting_AllTypes {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int[] question = {3,6,7,8,2,1,5,9};
        // 6 7 8 3 2 1 5 9

        // String[] Stringquestion = br.readLine().split(" ");
        // int[] question = Arrays.stream(Stringquestion).mapToInt(Integer::parseInt).toArray();

        // selectionSort(question);
        // bubbleSort(question);
        improvedBubbleSort(question);
        
        System.out.println(Arrays.toString(question));
    }

    static void selectionSort(int[] list) { //Select Largest and Swap with the end value. O(n) = n(n-1)/2 = n^2
        int maxID;
        int swapID = list.length-1;
        
        while (swapID != 0) {
            maxID = swapID;
            for (int j=0; j < swapID; j++) {
                if (list[j] > list[maxID])
                    maxID = j;
            } 

            int temp = list[swapID];
            list[swapID] = list[maxID];
            list[maxID] = temp;
            swapID--;
        }
    }

    static void bubbleSort (int[] list) { // O(n) = n(n-1)/2 = n^2
        for (int i=1; i < list.length; i++) { // Loop to keep the search length appropriate
            for (int j=0; j < list.length - i; j++) { //Loop to pass thru and bubble swap the array.
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;                   
                }
            }
        }
    }

    static void improvedBubbleSort (int[] list) { // Worst case would still be O(n) = n^2. BUT best case would be O(n) = n only.
        boolean isSorted = true;
        for (int i=1; i < list.length; i++) { // Loop to keep the search length appropriate
            for (int j=0; j < list.length - i; j++) { //Loop to pass thru and bubble swap the array.
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    isSorted = false;                   
                }
            }
        if (isSorted) return;
        }
    }

    static void insertionSort (int[] list) {
        
    }
}