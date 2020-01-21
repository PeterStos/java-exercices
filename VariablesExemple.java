import java.util.*;

public class VariablesExemple {

    // Method to remove the duplicated characters
    public static String removeDuplicates(String text) {

        if (text.equals("") || text.equals(null) || text.length() == 0) {
            return text.toString();
        }
        StringBuilder result = new StringBuilder();
        result = result.append(text.charAt(0));

        for (int i = 1; i < text.length(); i++) { // iterates through String text
            if (text.charAt(i) != text.charAt(i - 1)) { // test element is equal the previous one
                result = result.append(text.charAt(i)); // storage different element in result
            }
        }
        return result.toString(); // return result converting to String as requested
    }

    public static String uniqueCharacters(String text) {

        if (text.equals("") || text.equals(null) || text.length() == 0) {
            return text.toString();
        }

        HashSet<Character> hashTest = new HashSet<Character>(); // Creates the HashSet of Characters to test the content
        StringBuilder uniqueResult = new StringBuilder();

        for (int i = 1; i < text.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (!hashTest.contains(text.charAt(j))) {
                    hashTest.add(text.charAt(j));
                    uniqueResult = uniqueResult.append(text.charAt(j));
                }
            }
        }
        return uniqueResult.toString();
    }

    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {

        int count = 0;
        int k = 0;
        int l = 0;
        boolean test = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (rooks[i][j] == false) {
                    while(test == true && k < n) { 
                        if (rooks[i][k] == true) { //&& (k != j)
                            test = false;
                        }
                        k++; 
                    }
                    while(test == true && l < n) {
                        if (rooks[l][j] == true) { // && (l != i)
                            test = false;
                        }
                        l++;
                    }
                    if(test == true) {
                        count++;
                    }
                    
                }
                k = 0;
                l = 0;
                test = true;
            }

        }
        return count;
    }
        
    public static int recaman(int n) {

            boolean[] newValueTest = new boolean[10*n];
            int result = 0;
            int an1, an2 = 0;
            newValueTest[0] = true;

            for (int i = 1; i < newValueTest.length; i++) {
                newValueTest[i] = false;
            }

            for (int j = 1; j <= n; j++) {
                an1 = result - j; 
                if (an1 > 0 && newValueTest[an1] == false) { 
                    result = an1; 
                    newValueTest[an1] = true;
                }
                else {
                    an2 = result + j;
                    newValueTest[an2] = true;
                    result = an2;
                }
            }
            return result;
        }
    }