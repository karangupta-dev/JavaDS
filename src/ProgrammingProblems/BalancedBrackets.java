package ProgrammingProblems;

import java.util.Arrays;
import java.util.HashMap;

public class BalancedBrackets {


    boolean hasBalancedBrackets(String s) {

        String[] n = new String[s.length()];

        HashMap reverseMap = new HashMap();
        reverseMap.put('}', '{');


        boolean isValid = true;

        for (int i = 0; i < s.length(); i++) {
            if (reverseMap.get(s.charAt(i)) != null) {
                if ((i - 1) >= 0 && !(String.valueOf(s.charAt(i - 1)).equals('{'))) {
                    isValid = false;
                    break;
                }
            } else {
                n[i] = String.valueOf(s.charAt(i));
            }
        }

        System.out.println("Value of n array" + Arrays.toString(n));

        return isValid;
    }
}
