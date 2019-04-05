package Arslan.Ch08RecursionandDynamicProgramming.Q8_04_Power_Set;

import java.util.ArrayList;
import java.util.Collections;

/*
USEFULL TO RUN LOOPS WHOSE END IS NOT KNOWN
 */
public class Solution_A {


    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> answer= new ArrayList<>(); // WILL ONLY RUN FIRST TIME

        if(index==set.size()){                                   // ONLY RUN ONE TIME
            ArrayList<ArrayList<Integer>> initial= new ArrayList<>();
            ArrayList<Integer> empty= new ArrayList<>();
            initial.add(empty);
            return initial;
        }


        ArrayList<ArrayList<Integer>> subsets = getSubsets(set, index+1); //THIS GETS RUNN SEVERAL TIMES

        int item = set.get(index);
        ArrayList<ArrayList<Integer>>  subsets_save =new ArrayList<>();


        //Just copying array
        for (ArrayList<Integer> subset : subsets) {
            ArrayList<Integer> subsets1 =new ArrayList<>();
            for (Integer integer : subset) {
                subsets1.add(integer);
            }
            subsets_save.add(subsets1);
        }

        //add to each array element the new item
        for (ArrayList<Integer> arrayList : subsets) {
           arrayList.add(item);
        }

        //answer has previous values + changed values
        answer.addAll(subsets);
        answer.addAll(subsets_save);

        return answer;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
        System.out.println(subsets.size()); // Basically equal to 1+ 4c1 + 4c2 + 4c3 + 4c4 = 16
        System.out.println(subsets.toString());
    }

}
