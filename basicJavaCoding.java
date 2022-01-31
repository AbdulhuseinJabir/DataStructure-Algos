import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class basicJavaCoding {
    public static void main(String[] args) {
        
        //Convert an int[] to a comma separated String
        int[] test = {1, 2, 4, 5, 6, 7};

            //Method 1
            String result = IntStream.of(test)
                                    .mapToObj(Integer::toString) 
                                    .collect(Collectors.joining(", "));
            // System.out.println(result);
            
            //Method 2
            String answer = Arrays.toString(test);
            answer = answer.substring(1, answer.length()-1);
            System.out.println(answer);



        //Convert a String List<> to a comma separated output.
        List<String> list = new ArrayList<>(Arrays.asList("Abdulhusein", "Alifiya", "Jabir"));
        result = list.toString().replace("[", "").replace("]", "");
        System.out.println(result);

        //Different ways to initialise a List in java
        List<String> data =  Stream.of("Abd", "Mus", "Jab").collect(Collectors.toList());
        List<String> list1 = new ArrayList<>(Arrays.asList("Abdulhusein", "Alifiya", "Jabir"));

        //Shortcut to fix indentation in java on Visual Studio is Shift + Alt + F
    }
}
