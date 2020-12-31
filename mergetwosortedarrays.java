import java.util.*;

/**
 * This code is the merge sort part. It demonstrates the merging algo for two sorted arrays. 
 * 
 * Example input is
 * 1,3,3,4,5,8,9
 * 2,3,6,7,10
 */

public class mergetwosortedarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str1 = sc.nextLine().split(",");
        int[] line1 = Arrays.stream(str1).mapToInt(Integer::parseInt).toArray();
        String[] str2 = sc.nextLine().split(",");
        int[] line2 = Arrays.stream(str2).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[line1.length + line2.length];

        int i=0;
        int j=0;
        int k=0;
        while (i < line1.length && j < line2.length) {
            if (line1[i] < line2[j]) {
                answer[k++] = line1[i++];
            }
            else if (line1[i] > line2[j]) {
                answer[k++] = line2[j++];
            }
            else {
                answer[k++] = line1[i++];
            }
            
            // System.out.println(Arrays.toString(answer));
            // System.out.println(i + " " + j + " " + k);
            // // sc.next();
        }

        while (i < line1.length) answer[k++] = line1[i++];
        while (j < line2.length) answer[k++] = line2[j++];
        String finalans = Arrays.toString(answer).replaceAll("\\[|\\s|\\]", ""); //this means replace the [ in the front of the toString answer, //s means replace spaces and replace ] at the end with "" OR nothing.  
        System.out.println(finalans);
    }
    
}