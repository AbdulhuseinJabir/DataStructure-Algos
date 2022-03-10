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
        // improvedBubbleSort(question);
        insertionSort(question);
        
        System.out.println(Arrays.toString(question));

        int[] question1 = {1,9,2,4,5,6,7};
        mergeSort(question1, 0, question1.length-1);
        System.out.println(Arrays.toString(question1));
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

    static void insertionSort (int[] list) { //Best case is O(n) = n when array sorted. Worst case is when O(n) = n^2
        for (int i=1; i < list.length; i++) {
            int next = list[i];
            int j=0;
            for (j=i-1; j>=0 && list[j] >= next; j--) {
                list[j+1] = list[j];
            }
            list[j+1] = next;
        }    
    }

    static void mergeSort (int[] list, int i, int j) { // First level is level 0 with array of n values.
                                                       // Your tree will break into log(n) total levels. 
                                                       // Each merge -> if k = length of merged array. Then merge will take k-1 comparisons, k moves from original to temp and k moves vicse versa. Total = O(k). 
                                                       // Each level has 2^level arrays. 
                                                       // Each level will have call merge 2^(log(n)-1) times for arrays which are each of n/2^log(n) numbers. So working with total n elements only.
                                                       // Total to merge the last level with one number = constant or one

                                                       //Has additional space complexity of O(n) = n because of temp array required.

                                                       //Total levels = log(n)
                                                       //Each level, you are indirectly merging n values (that are broken into smaller arrays).
                                                       //Hence final time complexity for all levels = log(n) * n = nlog(n)

                                                       //Refere to pic mergeSortAnalysis.jpg  for mathematical derivation.
        if (i<j) {
            int mid = (i+j)/2;
            System.out.println(i + " " + mid);
            mergeSort(list, i, mid);
            System.out.println(mid+1 + "+" + j);
            mergeSort(list, mid+1, j);
            merge(list,i,mid,j);
        }
    }

    static int[] merge(int[] list, int i, int mid, int j) {
        int[] ans = new int[j-i+1];
        int left = i;
        int right = mid+1;
        int curr = 0;

        while(left <= mid && right <=j) {
            if (list[left] <= list[right]) {
                ans[curr++] = list[left++];
            } else {
                ans[curr++] = list[right++];
            }
        }

        while (left <= mid) ans[curr++] = list[left++];
        while (right <=j) ans[curr++] = list[right++];

        for (int k=0; k < ans.length; k++) {
            list[i+k] = ans[k];
        }

        return list;
    }


}