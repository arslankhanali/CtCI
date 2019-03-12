package Arslan.Ch08RecursionandDynamicProgramming;

public class Q8_01_A {

    public static int countWays(int n) {
    if(n<0)return 0;
    else if(n==0)return 1;
    else return countWays(n-1)+countWays(n-2)+countWays(n-3);
    }

    public static void main(String[] args) {
        int n = 20;
        int ways = countWays(n);
        System.out.println(ways);
    }

}
