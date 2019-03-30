package Arslan;

import Java.CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.Collections;

public class mergesort {


    public static ArrayList sort(ArrayList<Integer> s) {

        if (s.size() <= 1) {
            return s;
        }


        ArrayList<Integer> left = new ArrayList();
        ArrayList<Integer> right = new ArrayList();

        int count = 0;
        while (!s.isEmpty()) {
            count++;
            if (count % 2 == 0) {
                left.add(s.remove(s.size() - 1));
            } else {
                right.add((s.remove(s.size() - 1)));
            }
        }

        System.out.println(left);
        System.out.println(right);
        System.out.println("------------");

        left = sort(left);
        right = sort(right);

        
        ArrayList p= new ArrayList();
        while (left.size() > 0 || right.size() > 0) {
            if (left.isEmpty()) {
                p.add(right.remove(right.size() - 1));
            }
            else if (right.isEmpty()) {
                p.add(left.remove(left.size() - 1));
            }
            else if ((left.get(left.size() - 1) - right.get(right.size() - 1) >= 0)) {
                p.add(left.remove(left.size() - 1));
            }
            else {
                p.add(right.remove(right.size() - 1));
            }
        }

        System.out.println("before reverse "+p);
        Collections.reverse(p); //EXTREMLY IMPORTANT
        System.out.println("after reverse "+p);
        return p;
    }


    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 100);
            s.add(r);
        }
        System.out.println(s);

        ArrayList r = sort(s);


        //System.out.println(s.remove(2));

        System.out.println(r);
    }

}
