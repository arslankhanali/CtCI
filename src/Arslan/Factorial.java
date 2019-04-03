package Arslan;

public class Factorial {

    public static int factorial(int i){

        if(i==1)return 1;

        int count=0;

        if(i%2==0){
            count++;
        }

        return i*factorial(i-1);
    }


    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

}
