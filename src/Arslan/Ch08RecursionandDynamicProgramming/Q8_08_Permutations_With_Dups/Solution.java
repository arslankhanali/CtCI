package Arslan.Ch08RecursionandDynamicProgramming.Q8_08_Permutations_With_Dups;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] c=s.toCharArray();

        for (char c1 : c) {
            if(map.containsKey(c1)){
                int i=map.get(c1)+1;
                map.put(c1,i);
            }
            else{
                map.put(c1,1) ;
            }
        }

        return map;
    }
    //map,  prefix, remaining    , result
    //map,   ""   , s.length()=5 , result=empty
    public static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if(remaining==0){
            result.add(prefix);
            return;
        }
        for (Character character : map.keySet()) {
            int count = map.get(character);
            if(count>0){

                map.put(character,count-1);
                //prefix=prefix+character; //remaining--  //WRONG THIS WAY!!!!!! ;
                printPerms(map,prefix+character,remaining-1,result);
                map.put(character,count);
            }
        }
    }

    public static ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        System.out.println(map);
        printPerms(map, "", s.length(), result);
        return result;
    }

    public static void main(String[] args) {
        long startTime= System.currentTimeMillis();
        String s = "ababa";
        ArrayList<String> result = printPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
        long endTime= System.currentTimeMillis();
        long runTime= endTime-startTime;
        System.out.println("Time it took = "+runTime);
    }

}
