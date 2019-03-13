package Arslan.Ch01ArraysandStrings.Q1_02_Check_Permutation;

import java.util.Arrays;

public class Solution {

    public static boolean permutation(String s, String t) {

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();


        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String s1 = new String(ch1);
        String s2 = new String(ch2);

        if(s1.equals(s2)) return true;
        else return false;

    }


    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

}
