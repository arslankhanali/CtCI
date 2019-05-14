package Arslan.Ch08RecursionandDynamicProgramming.Q8_12_Eight_Queens;

import java.util.ArrayList;

public class Solution {

    public static int GRID_SIZE = 8;

    /* Check if (row1, column1) is a valid spot for a queen by checking if there
     * is a queen in the same column or diagonal. We don't need to check it for queens
     * in the same row because the calling placeQueen only attempts to place one queen at
     * a time. We know this row is empty.
     */
    public static boolean checkValid(Integer[] columns, int row1, int column1) {

        for (int i = 0; i <row1 ; i++) {

            int column2= columns[i];

            if(column1==column2){
                return false;
            }


            int dif_row=Math.abs(i-row1);
            int dif_col=Math.abs(column1-column2);


            if(dif_col==dif_row){
                return false;
            }

        }
        return true;

    }

    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {

        if(row==GRID_SIZE){
            results.add(columns.clone());
        }

        for (int i = 0; i < GRID_SIZE; i++) {

            if(checkValid(columns,row,i)){
                columns[row]=i;
                placeQueens(row+1,columns,results);
            }



        }
    }

    public static void clear(Integer[] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            columns[i] = -1;
        }
    }

    public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++){
                if (columns[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }



    public static void printBoards(ArrayList<Integer[]> boards) {
        for (int i = 0; i < boards.size(); i++) {
            Integer[] board = boards.get(i);
            printBoard(board);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        printBoards(results);
        System.out.println(results.size());
    }

}
