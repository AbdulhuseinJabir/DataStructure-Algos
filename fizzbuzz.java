/**
 * fizzbuzz Question
 * 
 * Output numbers from 1 to 100
 * If the number is divisible by 3 output fizz
 * If the number is divisible by 5 output buzz
 * If the number is divisible by 15 output fizzbuzz
 * else output the number
 */
public class fizzbuzz {

    public static void main(String[] args) {
        // mostSimpleCode();
        // moreBetterCode();
        bestCodeOutThere();
    }

    public static void mostSimpleCode() {
        for (int i = 1; i <= 100; i++) {
            if(i % 15 == 0)
                System.out.println("fizzbuzz");
            else if(i % 3 == 0)
                System.out.println("fizz");
            else if(i % 5 == 0)
                System.out.println("buzz");
            else
                System.out.println(i);
        }
    }

    public static void moreBetterCode() {
        for (int i = 1; i <= 100; i++) {
            if(i % 3 == 0)
                System.out.print("fizz");
            else if(i % 5 == 0)
                System.out.print("buzz");
            else
                System.out.print(i);
        System.out.println();
        }
    }

    public static void bestCodeOutThere() {
        int val1 = 1;
        int val2 = 1;

        for (int i = 1; i <= 100; i++) {
            StringBuilder answer = new StringBuilder();

            if (val1 == 3) {
                answer.append("fizz");    
                val1 = 0;
            }

            if (val2 == 5) {
                answer.append("buzz");    
                val2 = 0;
            }

            if (answer.length() == 0)
                System.out.println(i);
            else
                System.out.println(answer.toString());
            
            val1++;
            val2++;
        }
    }

}