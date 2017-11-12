package Arslan;

import java.util.ArrayList;
//NOT WORKING
public class Q8_08_A_Memoisation1 {

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
                char c= chars[i];
                char[] chars1= newCharminus(chars,i);
                getPermsRecur(newPrefix, chars1,k - 1);
                chars1= newCharadd(chars1,c);
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
        public static char[] newCharminus(char[] oldchar,int i) {
            String s= "";
            int j=0;
            for (char c : oldchar) {
                if (j!=i)s+=c;
                j++;
            }
            return s.toCharArray();
        }

        //char[] minus the char at i
        public static char[] newCharadd(char[] oldchar,Character c) {
            String ss= new String(oldchar);
            ss+=c;
            return ss.toCharArray();
        }

        public static void main(String[] args) {
            long startTime= System.currentTimeMillis();
            ArrayList<String> list = getPerms("aaaaaaaa");
            System.out.println("There are " + list.size() + " permutations.");
            for (String s : list) {
                System.out.println(s);
            }

            long endTime= System.currentTimeMillis();
            long runTime= endTime-startTime;
            System.out.println("Time it took = "+runTime);
        }
    }


