package Arslan.Ch01ArraysandStrings.Q1_01_Is_Unique;

public class Solution {
    public static boolean isUniqueChars(String str) {

        char[] ch= str.toCharArray();
        for (int i=0;i<ch.length;i++) {

            for (int j=i+1;j<ch.length;j++) {
                    if(ch[i]==ch[j]){
                        return false;
                    }

            }

        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
