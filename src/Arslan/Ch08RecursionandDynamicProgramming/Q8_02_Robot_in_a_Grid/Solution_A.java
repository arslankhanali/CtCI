package Arslan.Ch08RecursionandDynamicProgramming.Q8_02_Robot_in_a_Grid;

import Java.CtCILibrary.AssortedMethods;

import java.util.ArrayList;
public class Solution_A {
    public static ArrayList<Point> getPath(boolean[][] maze){
        if(maze==null|| maze.length==0 || maze[maze.length-1][maze.length-1]==false)return null;
        ArrayList<Point> path = new ArrayList<Point>();

        getPath(maze, maze.length-1 , maze.length-1,path);
        //System.out.println(path);
        return path;
    }


    public static boolean getPath(boolean[][] maze, int row, int col,ArrayList<Point> path){
        if(col<0 || row<0 || maze[row][col]==false || path.contains(new Point(row,col)) ){
            return false;
        }

// If I did it like this, I got some incomplete paths as well
// which would have lead to destination as well eventually
//        if(row==0 && col==0){
//            return true;
//        }

        boolean isAtOrigin = (row == 0) && (col == 0);
        boolean one=getPath(maze,row-1,  col   ,path);
        boolean two=getPath(maze,     row,col-1 ,path);


// if isoriginis true then last calls(one or two) also end up being true
// returning us the path
        if(isAtOrigin || one || two){
            path.add(new Point(row,col));//
            return true;

        }

        return false;
    }


    public static void main(String[] args) {
        int size = 5;
        boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);

        AssortedMethods.printMatrix(maze);
        System.out.println("MAZE shown above");

        long t1=System.nanoTime();
        ArrayList<Point> path = QuestionA.getPath(maze);
        long t2=System.nanoTime();
        System.out.println("Solution implementation: "+ (t2-t1));

        t1=System.nanoTime();
        ArrayList<Point> path1 = getPath(maze);
        t2=System.nanoTime();
        System.out.println("My implementation: "+ (t2-t1));


        if (path != null) {
            System.out.println(path.toString());
            System.out.println(path1.toString());
        } else {
            System.out.println("No path found.");
        }
    }
}
