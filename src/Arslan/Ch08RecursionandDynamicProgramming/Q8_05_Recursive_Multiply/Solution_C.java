package Arslan.Ch08RecursionandDynamicProgramming.Q8_05_Recursive_Multiply;

public class Solution_C {

    public static int counter = 0;

    public static int minProductHelper(int smaller, int bigger) {
        if(smaller==0)return 0;
        else if(smaller==1)return bigger;


        int s= smaller>>1;

        int temp= minProduct(s,bigger);

        if(smaller%2==0){
            return temp+temp;
        }
        else {
            return temp+temp+bigger;
        }

    }


    public static int minProduct(int a, int b) {
        int smaller = b;
        int bigger = a;

        if (a < b) {
            smaller = a;
            bigger = b;
        }

        return minProductHelper(smaller, bigger);

    }

    public static void main(String[] args) {
        int a = 13;
        int b = 7;
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
