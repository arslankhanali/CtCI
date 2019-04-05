package Arslan.Ch08RecursionandDynamicProgramming.Q8_03_Magic_Index;

import Java.CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class Solution {


    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    // -10 -5 2 2 2 3 4 7 9 12 13 -> midvalue
    //   0  1 2 3 4 5 6 7 8  9 10 -> midindex

    public static int magicFast(int[] array, int start, int end) {
        if (end < start) return -1;

        int midindex = (end + start) / 2; //5
        int midvalue = array[midindex];  //3

        if (midvalue == midindex) {
            return midindex;
        }
        else if (midvalue > midindex) {
            return magicFast(array, start, midindex-1);

        }
        else {
            return magicFast(array, midindex+1, end);
        }
    }

    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    /* Creates an array that is sorted */
    public static int[] getSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            int[] array = Question.getDistinctSortedArray(size);
            int v2 = magicFast(array);
            if (v2 == -1 && magicSlow(array) != -1) {
                int v1 = magicSlow(array);
                System.out.println("Incorrect value: index = -1, actual = " + v1 + " " + i);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            } else if (v2 > -1 && array[v2] != v2) {
                System.out.println("Incorrect values: index= " + v2 + ", value " + array[v2]);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            }
        }
    }

}
