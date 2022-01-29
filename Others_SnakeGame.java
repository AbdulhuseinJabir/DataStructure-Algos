/*

Probably all of us remember a game called Snake, where you have to eat as many apples as you can.
As you may guess your task is to write a program which determines whether our snake wins the game
or it ends up eating itself. Snake moves along an infinitely large board. It can turn left, right
or go straight. Also, the snake - when going straight - can eat an apple under the condition it is
in front of him. If such a scenario occurs our friend extends onto a cell where the meal took place.
The initial snake length is 1.

Input:
The first line of the input contains the number of tests t (t < 1001). Each of the next t lines
consists of an integer n (n < 2401) and n characters describing snake's movements. Each character 
is one of four letters: 'L', 'R', 'F' or 'E'. 'L' - snake goes on the field on his left, 
'R' - snake goes right, 'F' - snake goes on the field in front of him, 'E' - as previous but with
eating an apple.

Output:
For each test, you should print YES if the snake survives the whole game without dying or otherwise 
print the number of the step in which the snake bites itself.

Example

Input:
2
6 FLERFF
8 EEEELLLL

Output:
YES
7

*/

import java.util.*;

public class SnakeGame {
  public static void main(String [] args) {
    try {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int a;
      for (int i=0; i<t; i++) {
          int n = sc.nextInt();
          int x = 0;
          int y = 0;
          ArrayList<Point> snake = new ArrayList<>();
          snake.add(new Point(x,y)); // add intition (0,0) point
          String moves = sc.next();
          boolean flag = false;
          String currDir = "Up";

          for (a=0; a<n; a++) {
            char currMove = moves.charAt(a);
            //Logic for grid traversal with direction
            if (currDir.equals("Up")) {
                if (currMove == 'L') {
                    x--;
                    currDir = "Left";
                } else if (currMove == 'R') {
                    x++;
                    currDir = "Right";
                } else {
                    y++;
    
                }
            } else if (currDir.equals("Left")) {
                if (currMove == 'L') {
                    y--;
                    currDir = "Dwn";
                } else if (currMove == 'R') {
                    y++;
                    currDir = "Up";
                } else {
                    x--;
                }
            } else if (currDir.equals("Right")) {
                if (currMove == 'L') {
                    y++;
                    currDir = "Up";
                } else if (currMove == 'R') {
                    y--;
                    currDir = "Dwn";
                } else {
                    x++;
                }
            } else if (currDir.equals("Dwn")) {
                if (currMove == 'L') {
                    x++;
                    currDir = "Right";
                } else if (currMove == 'R') {
                    x--;
                    currDir = "Left";
                } else {
                    y--;
                }
            }
            
            Point newPoint = new Point(x, y);
            
            if ((currMove == 'L' || currMove == 'R' || currMove == 'F') && a != 0) {
                snake.remove(0); // remove the end point because snake is of fixed length
            }
            
            flag = checkPointEqual(newPoint, snake);
            if (flag) break;
            snake.add(newPoint);
            
          }
        if (flag) {
            System.out.println(a+1); //Print number of steps before snake eats itself.
        }
        else {
            System.out.println("YES"); // else print survived
        } 
      }
    } catch (Exception e) {}
  }

    static boolean checkPointEqual (Point newPoint, ArrayList<Point> snake) {
        for (int b=0; b < snake.size(); b++) {
            if (newPoint.equals(snake.get(b))) {
                return true;
            }
        }
        return false;
    }
    
}

class Point {
    
    private int x;
    private int y;
    
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getx () {
        return this.x;
    }

    public int gety () {
        return this.y;
    }

    public boolean compareWith (Point p2) {
        return (this.x == p2.getx() && this.y == p2.gety()); 
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point p1 = (Point) o;
        return this.x == p1.getx() && this.y == p1.gety(); 
    }

    @Override
    public String toString() {
        return "x = " + x + "y = " + y;
    }

}