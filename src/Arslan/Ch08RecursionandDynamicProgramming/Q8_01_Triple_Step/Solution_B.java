package Arslan.Ch08RecursionandDynamicProgramming.Q8_01_Triple_Step;

public class Solution_B {
    public static int countWays(int n) {
        return countWays(n,new int[n+1]);
    }
    public static int countWays(int n,int[] memo) {
        if(n==0){
            return 1;
        }
        else if(n<0){
            return 0;

        }
        else if(memo[n]==0) {


            int c1=countWays(n-1,memo);
            int c2=countWays(n-2,memo);
            int c3=countWays(n-3,memo);

            memo[n]=c1+c2+c3;

            return memo[n];

        }

        return memo[n];
    }


    public static void main(String[] args) {
        int n = 4;
        int ways = countWays(n);
        System.out.println("121415 =="+ways);
    }
}
