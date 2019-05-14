package Arslan.Ch08RecursionandDynamicProgramming.Q8_11_Coins;

public class Solution {

    public static int makeChange(int amount, int[] denoms, int index) {

        if(index>=denoms.length-1){

            return 1;}

        int ways=0;

        int denom=denoms[index];

            for (int i = 0; i*denom <= amount; i++) {

                int remain=amount-i*denom;

                ways+=makeChange(remain,denoms,index+1);


            }
        return ways;
    }

    public static int makeChange(int amount, int[] denoms) {
        return makeChange(amount, denoms, 0);
    }

    public static void main(String[] args) {
        int[] denoms = {25, 10, 5, 1};
        int ways = makeChange(30, denoms);
        System.out.println(ways);
    }
}
