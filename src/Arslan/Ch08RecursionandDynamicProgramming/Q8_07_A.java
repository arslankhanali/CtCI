package Arslan.Ch08RecursionandDynamicProgramming;

import java.util.ArrayList;

public class Q8_07_A {
    static ArrayList<String> al;
    static char[] ans;

    //wrapper
    public static ArrayList<String> getPerms(String str) {
        al = new ArrayList<>();
        char[] chars=stringToChar(str);
        getPermsRecur("",chars,chars.length);
        return al;
    }

    //main recursion func
    public static void getPermsRecur(String prefix,char[] chars,int k){
        if (k == 0) {
            al.add(prefix);
            return;
        }
        for (int i = 0; i < chars.length; ++i) {
            String newPrefix = prefix + chars[i];
            char[] chars1= newChar(chars,i);
            getPermsRecur(newPrefix, chars1,k - 1);
        }
    }

    //str to char[]
    public static char[] stringToChar(String str) {
        return str.toCharArray();
    }

    //char[] to str
    public static String charToSring(char[] chars) {
        return new String(chars);
    }

    //char[] minus the char at i
    public static char[] newChar(char[] oldchar,int i) {
        String s= "";
        int j=0;
        for (char c : oldchar) {
            if (j!=i)s+=c;
            j++;
        }
        return s.toCharArray();
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
