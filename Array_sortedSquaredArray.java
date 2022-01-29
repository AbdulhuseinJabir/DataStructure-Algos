import java.util.stream.*;
import java.util.Arrays;

public class Array_sortedSquaredArray {
    public static void main(String[] args) {
        int[] array = {-6, -4, 1, 2, 3, 5}; 
        // int[] answer = sortingSolution(array);
        int[] answer = bestSolution(array);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] sortingSolution(int[] array) {// This is the most normal way to solve it. It has time complexity of NlogN. Not the best. 
        int[] squaredArray = Arrays.stream(array).map(a -> a*a).toArray();
        Arrays.sort(squaredArray);
        return squaredArray;
    }

    public static int[] bestSolution(int[] array) {
        int start = 0, end = array.length - 1, tail = array.length - 1; 
        int[] answer = new int[tail+1];
        while (start <= end) {
            if (Math.abs(array[start]) > array[end]) {
                answer[tail] = (int) Math.pow(array[start], 2);
                start++;
                tail--;
            } else {
                answer[tail] = (int) Math.pow(array[end], 2);
                end--;
                tail--;                
            }
        }
        return answer;
    }

}
