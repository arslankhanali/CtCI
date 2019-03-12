package Arslan.Ch08RecursionandDynamicProgramming;

import java.util.HashSet;

public class Q8_08_A {
    static HashSet<String> al;
    static char[] ans;

    //wrapper
    public static HashSet<String> getPerms(String str) {
        al = new HashSet<>();
        char[] chars=stringToChar(str);
        //printchar(chars);

        //char[] chars1=uniquechar(chars);
        //printchar(chars1);

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
            System.out.println("1="+newPrefix);
            getPermsRecur(newPrefix, chars1,k - 1);
            System.out.println("2="+newPrefix);
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

    //char[] minus the char at i
    public static char[] uniquechar(char[] oldchar) {
        HashSet<Character> hashSet= new HashSet<>();
        for (char c : oldchar) {
            hashSet.add(c);
        }
        char[] ans = new char[hashSet.size()];
        int j=0;
        for (Character character : hashSet) {
            ans[j]=character;
            j++;
        }
        return ans;
    }

    //char[] minus the char at i
    public static void printchar(char[] oldchar) {
        for (char c : oldchar) {
            System.out.print(c+", ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        long startTime= System.currentTimeMillis();
        String s = "aabb";
        HashSet<String> result = getPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
        long endTime= System.currentTimeMillis();
        long runTime= endTime-startTime;
        System.out.println("Time it took = "+runTime);
    }
}
