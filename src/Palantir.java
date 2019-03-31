import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Palantir {

// IF STRING HAS +-
// reverse for !
// if brackets then shift things in bracket with its own procedures


    public static String encrypt (String message , int shift){
        char[] chars=message.toCharArray();
        shift=shift+1;

        for (int i = 0; i < chars.length; i++) {
            //System.out.println("SHIFTold: "+shift);
            //System.out.println("char    : "+chars[i]);
            if(48<= chars[i] && chars[i] <=57){
                shift =shift+ chars[i]-48;
            }

            else if(97<= chars[i] && chars[i]<=122){
                //System.out.println(chars[i]+" "+shift);

                if(chars[i]+shift>122){
                    //System.out.println("LOOP1 "+chars[i]+" "+shift);
                    chars[i]= (char) (((chars[i]+shift)%122)+96);
                }
                else if(chars[i]+shift<=122){
                    //System.out.println("LOOP2 "+chars[i]+" "+shift);
                  chars[i]= (char) ((chars[i]+shift));
                }
            }

            //System.out.println("SHIFTnew: "+shift);

        }

        return new String(chars);
    }

    public static void main(String[] args) {


        String s =       "he2l9lo wo1rld@";

        String expected= "kh2q9zc kc1gas@";

        String result=encrypt(s,2);
        System.out.println(result);


    }
    @Test
    public void testencrypt() {
        String s ="he2l9lo wo1rld@";

        String expected= "kh2q9zc kc1gas@";

        String result=encrypt(s,2);

        assertTrue(expected.equals(result));
    }
}
