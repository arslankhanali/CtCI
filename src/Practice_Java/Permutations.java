package Practice_Java;

import java.util.ArrayList;

public class Permutations {


    public static void permutation(ArrayList c, StringBuilder sb,ArrayList<String> list){

        System.out.println(sb.toString());
        if(sb.length()==3){
            list.add((sb.toString()));
            return;
        }

        for (Object o : c) {
            sb.append(o);
            c.remove(o);
            permutation(c,sb,list);
            c.add(o);
        }



    }


    public static ArrayList<String> permutation(String string){
        ArrayList<String> list= new ArrayList<>();

        char[] c= string.toCharArray();

        ArrayList<Character> array= new ArrayList<>();

        for (char c2 : c) {
            array.add(c2);
        }

        StringBuilder sb= new StringBuilder();

        permutation(array,sb,list);

        return list;
    }


    public static void main(String[] args) {
        String s="ABC";

        ArrayList list= permutation(s);

        System.out.println(list);

    }
}
