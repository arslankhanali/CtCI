package Practice_Java.Agile;

import java.util.Scanner;

/*   A squad of robotic explorers are to be landed in Uluru.

   The landing area is rectangular and must be navigated by the robots so that their on-board cameras can get a complete view
   of the surrounding terrain to send back to Canberra.

   A robot’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the
   four cardinal compass points. The landing area in Uluru is divided up into a grid to simplify navigation. An example position
   might be 0, 0, N, which means the robot is in the bottom left corner and facing North.

   In order to control a robot, we send a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’
   makes the robot spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward
   one grid point, and maintain the same heading.

   Assume that the square directly North from (x, y) is (x, y+1).

   INPUT:

   The first line of input is the upper-right coordinates of the landing area, the lower-left coordinates are assumed to be 0,0.

   The rest of the input is information pertaining to the robots that have been deployed. Each explorer has two lines of input.
   The first line gives the explorer’s position, and the second line is a series of instructions telling the explorer how to
   explore the Uluru landing zone.

   The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and
   the explorer’s orientation.

   Each explorer will be finished sequentially, which means that the second explorer won’t start to move until the first one
   has finished moving.

   OUTPUT:

   The output for each explorer should be its final co-ordinates and heading.


   COMMAND LINE INPUT AND OUTPUT:

   Test Input:
           5 5
           1 2 N
           LMLMLMLMM
           3 3 E
           MMRMMRMRRM

          Expected Output:
           1 3 N
           5 1 E
   */
public class Agile_Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //System.out.println("Enter dimensions of landing area e.g. 5 5");
        String s = in.nextLine();
        char[] charArray = s.toCharArray();
        int max_x = Character.getNumericValue(charArray[0]);
        int max_y = Character.getNumericValue(charArray[s.length() - 1]);

        //System.out.println("Dimensions given are, x="+max_x+" y="+max_y);


        //System.out.println("Give landing co-ordinates and direction for a robot e.g. 1 2 N");
        String input_robot_string = in.nextLine();
        char[] input_robot_char = input_robot_string.toCharArray();
        int x = Character.getNumericValue(input_robot_char[0]);
        ;
        int y = Character.getNumericValue(input_robot_char[2]);
        ;
        char face = input_robot_char[4];

        //System.out.println("Robot landed at, x="+x+" y="+y+" facing "+face);

        //System.out.println("Give moving instructions to the robot e.g. LMLMLMLMM");
        String input_moving_instructions = in.nextLine();
        //System.out.println("Moving instructions is "+ input_moving_instructions);


        Robot r = new Robot(max_x, max_y, x, y, face);
        r.command(input_moving_instructions);
        //System.out.println("New position: "+ r);
        //System.out.println("-------TIME TO LAND ANOTHER ROBOT------");


        String input_robot_string1 = in.nextLine();
        char[] input_robot_char1 = input_robot_string1.toCharArray();
        int x1 = Character.getNumericValue(input_robot_char1[0]);
        int y1 = Character.getNumericValue(input_robot_char1[2]);
        char face1 = input_robot_char1[4];
        String input_moving_instructions1 = in.nextLine();
        Robot r1 = new Robot(max_x, max_y, x1, y1, face1);
        r1.command(input_moving_instructions1);


        System.out.println(r);
        System.out.println(r1);


    }

}
