package Arslan.Ch08RecursionandDynamicProgramming.Q8_09_Parens;

import java.util.ArrayList;
import java.util.HashSet;

//Completely my own code


public class Solution {

    public static ArrayList<String> generateParanthesis(int remaining) {

        if(remaining==1){
            ArrayList<String> result1 = new ArrayList<>();
            result1.add("()");
            return result1;
        }
        if(remaining==2){
            ArrayList<String> result2 = new ArrayList<>();
            result2.add("()()");
            result2.add("(())");
            return result2;
        }


        ArrayList<String> temp=generateParanthesis(remaining-1);

        ArrayList<String> result_final = new ArrayList<>();
        HashSet<String> result = new HashSet<>();

        for (String s : temp) {
            ArrayList<String> r = insertParanthesis(s);
            result.addAll(r);
        }

        result_final.addAll(result);

        return result_final;

    }

    public static ArrayList<String> insertParanthesis(String prev) {
        ArrayList<String> result = new ArrayList<>();

        //enclose
        result.add("(" + prev + ")");

        result.add(prev + "()");
        result.add( "()"+prev);
        int l = prev.toCharArray().length;
        char[] c = prev.toCharArray();


        for (int i = 0; i < l; i++) {
            if (c[i] == '(') {

                String s1 = prev.substring(0,i+1);
                String s2 = prev.substring(i+1);
                result.add(s1 + "()" + s2);

            }
        }


        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();

        //System.out.println(insertParanthesis("(()())"));


        result = generateParanthesis(5);

        System.out.println("Total combination found: " + result.size());

        for (String s : result) {
            System.out.println(s);
        }
    }
}
