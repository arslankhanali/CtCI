package Arslan.Ch08RecursionandDynamicProgramming.Q8_07_Permutations_Without_Dups;

import java.util.ArrayList;

public class Solution {


    public static ArrayList<String> getPerms(String str) {
        ArrayList<String> permutations= new ArrayList<>();

        if (str == null) {return null;}


        if(str.length()<=1){
            permutations.add(str);
            return permutations;
        }


        char c= str.charAt(0);
        String remainingString= str.substring(1);

        ArrayList<String> perms= getPerms(remainingString);

        System.out.println(perms+" "+c);
        for (String perm : perms) {
            permutations.addAll(addAtEachLocation(perm,c));
        }

        return permutations;
    }

    public static ArrayList<String> addAtEachLocation(String str,char c) {

        ArrayList<String> ans= new ArrayList<>();

        ans.add(c+str); // Add at start

        // Loop adds in the middle
        for (int i = 0; i < str.length()-1; i++) {

            String s1=str.substring(0,i+1);
            String s2=str.substring(i+1);
            ans.add(s1+c+s2);
        }

        ans.add(str+c); //Add at end



        return ans;
    }

    public static void main(String[] args) {

        ArrayList<String> list = getPerms("abcd");

        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }





    }



}
