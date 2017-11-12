package Arslan;

import java.util.Arrays;

public class Q8_01_B {
    public static int countWays(int n) {
        int[] map = new int[n + 1];
        Arrays.fill(map, -1);
        return countWays(n, map);
    }

    public static int countWays(int n, int[] memo) {
        if(n<0)return 0;
        else if(n==0)return 1;
        else if(memo[n] == -1){
            memo[n]= countWays(n-1,memo)+countWays(n-2,memo)+countWays(n-3,memo);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 60;
        int ways = countWays(n);
        System.out.println(ways);
    }
}