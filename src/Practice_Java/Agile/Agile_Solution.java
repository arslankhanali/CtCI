package Practice_Java.Agile;

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
           LM LM LM LM M
           3 3 E
           MM RMM RM RRM

          Expected Output:
           1 3 N
           5 1 E
   */
public class Agile_Solution {
    public static int i = 0, j = 0;


    public static void main(String[] args) {
        Robot r = new Robot(1, 2, 'N');
        r.command("LMLMLMLMM");
        System.out.println(r);

        Robot r1 = new Robot(3, 3, 'E');
        r1.command("MMRMMRMRRM");
        System.out.println(r1);

        Robot r2 = new Robot(0, 0, 'W');
        r2.command("RLMMLRMMRLMRLMRLRMRRLMMMRRRRMMMMMM");
        System.out.println(r2);
    }

}
