package Arslan.Ch08RecursionandDynamicProgramming.Q8_05_Recursive_Multiply;
/*
* Inefficiant solution

* */
public class Solution {



    public static int counter = 0;

    public static int minProduct(int a, int b) {
      int answer= 0;
        if(b==0){
            return 0;
        }

        answer= minProduct(a,b-1);
        answer=answer+a;


        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int product = a * b;
        int minProduct = minProduct(a, b);
        if (product == minProduct) {
            System.out.println("Success: " + a + " * " + b + " = " + product);
        } else {
            System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of " + minProduct);
        }
        System.out.println("Adds: " + counter);
    }

}
