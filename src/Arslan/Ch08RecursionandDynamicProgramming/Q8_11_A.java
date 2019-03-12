package Arslan.Ch08RecursionandDynamicProgramming;

public class Q8_11_A {

    public static int makeChange(int amount, int[] denoms) {
        int[] combinations= new int[amount+1];
        combinations[0]=1;

        for (int denom : denoms) {
            for (int i=1;i<combinations.length;i++){
                if(i>=denom){
                    combinations[i]+=combinations[i-denom];
                }
            }
        }
        return combinations[amount];
    }

    public static void main(String[] args) {
        int[] denoms = {25, 10, 5, 1};
        int ways = makeChange(3003, denoms);
        System.out.println(ways);
    }
}
