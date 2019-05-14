package Arslan.Ch08RecursionandDynamicProgramming.Q8_06_solution;

import Arslan.Ch08RecursionandDynamicProgramming.Q8_06_Towers_of_Hanoi.Tower;

import java.util.Stack;

public class solution {

    private Stack<Integer> disks;
    private int index;
    public solution(int i) {
        disks = new Stack<Integer>();
        index = i;
    }

    public int index() {
        return index;
    }

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    public void moveTopTo(solution t) {
        int top = disks.pop();
        t.add(top);
    }

    public void print() {
        System.out.println("Contents of solution " + index() + ": " + disks.toString());
    }

    public void moveDisks(int n, solution destination, solution buffer) {
        if(n>0){
            moveDisks(n-1,buffer,destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1,destination,this);
            
        }
    }

/*
        ABC
        ACB

        CBA

 */

    public static void main(String[] args) {
        // Set up code.
        int n = 5;
        solution[] towers = new solution[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new solution(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        // Copy and paste output into a .XML file and open it with internet explorer.
        towers[0].print();
        towers[0].moveDisks(n, towers[2], towers[1]);
        towers[2].print();
    }
    }
