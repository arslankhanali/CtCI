package Arslan.Ch08RecursionandDynamicProgramming.Q8_01_Triple_Step;

public class Solution_A {


    public static int countWays(int n) {
       if(n==0){
           return 1;
       }
       else if(n<0){
           return 0;

       }
       else {

           int c1=countWays(n-1);
           int c2=countWays(n-2);
           int c3=countWays(n-3);

           return c1+c2+c3;
       }

    }

    public static void main(String[] args) {
        int n = 20;
        int ways = countWays(n);
        System.out.println("121415 =="+ways);
    }
}
