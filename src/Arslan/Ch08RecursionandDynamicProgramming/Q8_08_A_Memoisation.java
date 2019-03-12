package Arslan.Ch08RecursionandDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// USING ARRAY LIST INSTEAD OF HASHSET TO CHECK IMPLEMENTATION
// USE HASHSET IDEALLY

public class Q8_08_A_Memoisation {
    static HashSet<String> al;
    static char[] ans;

    //wrapper
    public static HashSet<String> getPerms(String str) {
        al = new HashSet<>();
        char[] chars=stringToChar(str);
        HashMap<Character, Integer> map = buildFreqTable( str);
        System.out.print("buildFreqTable gave = ");
        printmap(map);
        printchar(chars);

        getPermsRecur(map,"",chars,chars.length);
        return al;
    }

    //main recursion func
    public static void getPermsRecur(HashMap map,String prefix,char[] chars,int k){
        if (k == 0) {
            al.add(prefix);
            return;
        }

        for (Object o : map.keySet()) {
            int count=(int) map.get(o);
            if(count>0){
                String newPrefix = prefix + o;
                map.put(o,count-1);
                                                                                                System.out.println("count = "+count+", char is = "+o+", L1="+newPrefix);
                getPermsRecur(map,newPrefix, chars,k - 1);
                                                                                                System.out.println("count = "+count+", char is = "+o+", L2="+newPrefix);
                map.put(o,count);
            }
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

    //char[] minus the char at i
    public static void printmap(HashMap<Character, Integer> map) {
        for (Character key : map.keySet()) {
            System.out.println(key+" , "+map.get(key));
        }
    }

    public static HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }



    public static void main(String[] args) {
        long startTime= System.currentTimeMillis();
        String s = "aaa";
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

/*
count = , char is = a, L1=a                         count = 2, char is = a, L1=a
count = , char is = a, L1=aa                        count = 1, char is = a, L1=aa
count = , char is = a, L1=aaa                        count = 2, char is = b, L1=aab
count = , char is = a, L2=aaa                        count = 1, char is = b, L1=aabb
count = , char is = b, L1=aab                        count = 1, char is = b, L2=aabb
count = , char is = b, L2=aab                        count = 2, char is = b, L2=aab
count = , char is = c, L1=aac                        count = 1, char is = a, L2=aa
count = , char is = c, L2=aac
count = , char is = a, L2=aa                         count = 2, char is = b, L1=ab
count = , char is = b, L1=ab                         count = 1, char is = a, L1=aba
count = , char is = a, L1=aba                         count = 1, char is = b, L1=abab
count = , char is = a, L2=aba                         count = 1, char is = b, L2=abab
count = , char is = b, L1=abb                         count = 1, char is = a, L2=aba
count = , char is = b, L2=abb
count = , char is = c, L1=abc                         count = 1, char is = b, L1=abb
count = , char is = c, L2=abc                         count = 1, char is = a, L1=abba
count = , char is = b, L2=ab                         count = 1, char is = a, L2=abba
count = , char is = c, L1=ac                         count = 1, char is = b, L2=abb
count = , char is = a, L1=aca                         count = 2, char is = b, L2=ab
count = , char is = a, L2=aca                         count = 2, char is = a, L2=a
count = , char is = b, L1=acb
count = , char is = b, L2=acb                         count = 2, char is = b, L1=b
count = , char is = c, L1=acc                         count = 2, char is = a, L1=ba
count = , char is = c, L2=acc                         count = 1, char is = a, L1=baa
count = , char is = c, L2=ac                         count = 1, char is = b, L1=baab
count = , char is = a, L2=a                         count = 1, char is = b, L2=baab
count = , char is = b, L1=b                         count = 1, char is = a, L2=baa
count = , char is = a, L1=ba
count = , char is = a, L1=baa                         count = 1, char is = b, L1=bab
count = , char is = a, L2=baa                         count = 1, char is = a, L1=baba
count = , char is = b, L1=bab                         count = 1, char is = a, L2=baba
count = , char is = b, L2=bab                         count = 1, char is = b, L2=bab
count = , char is = c, L1=bac                         count = 2, char is = a, L2=ba
count = , char is = c, L2=bac
count = , char is = a, L2=ba                         count = 1, char is = b, L1=bb
count = , char is = b, L1=bb                         count = 2, char is = a, L1=bba
count = , char is = a, L1=bba                         count = 1, char is = a, L1=bbaa
count = , char is = a, L2=bba                         count = 1, char is = a, L2=bbaa
count = , char is = b, L1=bbb                         count = 2, char is = a, L2=bba
count = , char is = b, L2=bbb                         count = 1, char is = b, L2=bb
count = , char is = c, L1=bbc                         count = 2, char is = b, L2=b
count = , char is = c, L2=bbc
count = , char is = b, L2=bb
count = , char is = c, L1=bc
count = , char is = a, L1=bca
count = , char is = a, L2=bca
count = , char is = b, L1=bcb
count = , char is = b, L2=bcb
count = , char is = c, L1=bcc
count = , char is = c, L2=bcc
count = , char is = c, L2=bc
count = , char is = b, L2=b
count = , char is = c, L1=c
count = , char is = a, L1=ca
count = , char is = a, L1=caa
count = , char is = a, L2=caa
count = , char is = b, L1=cab
count = , char is = b, L2=cab
count = , char is = c, L1=cac
count = , char is = c, L2=cac
count = , char is = a, L2=ca
count = , char is = b, L1=cb
count = , char is = a, L1=cba
count = , char is = a, L2=cba
count = , char is = b, L1=cbb
count = , char is = b, L2=cbb
count = , char is = c, L1=cbc
count = , char is = c, L2=cbc
count = , char is = b, L2=cb
count = , char is = c, L1=cc
count = , char is = a, L1=cca
count = , char is = a, L2=cca
count = , char is = b, L1=ccb
count = , char is = b, L2=ccb
count = , char is = c, L1=ccc
count = , char is = c, L2=ccc
count = , char is = c, L2=cc
count = , char is = c, L2=c


 */