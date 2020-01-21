import java.util.*;
    
public class ArraysArithmetic {
    
    // Method Falling Power compute and return the falling power nk
    // where n can be any integer, and k can be any nonnegative integer.
    public static long fallingPower(int n, int k) {
        long res = n - k + 1; 
        if (k == 0) {
            return 1;
        }
        for (int i = n - k + 1; i < n; i++) {
            res = res * (i+1);
        }
        return res;
    }

   // Method creates and return the elements in the odd positions
   public static int[] everyOther(int[] arr){

        int[] arrResult = new int[0];
        
        for (int i = 0; i < arr.length; i = i + 2) {
            arrResult = Arrays.copyOf(arrResult, arrResult.length + 1);
            arrResult[arrResult.length - 1] = arr[i];
        } 
        return arrResult;    
    }
   
   // Method creates and returns a new two-dimensional integer array
   public static int[][] createZigZag(int rows, int cols, int start) {
       int[][] twoDimArr = new int[rows][cols]; 
       int nextElem = start;
       
       for(int row = 0; row < rows; row ++) {
           if ((row % 2 == 0) || (row == 0)) {  // If is the first row or even rows
           for(int col = 0; col < cols; col ++) { // Storage in ascending order
               twoDimArr[row][col] = nextElem;
               nextElem += 1;
           }
           }
           else {
               for(int col = cols-1; col >= 0; col --) {  // Storage in descending order
                   twoDimArr[row][col] = nextElem;
                   nextElem += 1;
               }
           }
       }
       return twoDimArr;
   }
   
   // Method creates and returns a new two-dimensional integer array
   public static int countInversions(int[] arr){
       int countInv = 0;
       
       for(int i = 0; i < arr.length; i++) {
           for(int j = 1; j < arr.length; j++) {
               if ((i < j) && (arr[i] > arr [j])) {
                   countInv++;
               }
           }
       }
       return countInv;
   }
}