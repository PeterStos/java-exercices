import java.util.*;
import java.math.*;
import java.util.List;
import java.util.ArrayList;

public class Polynomial implements Comparable<Polynomial>{

    private int[] coefficients = null;

    ArrayList<Integer> polynomial = new ArrayList<Integer>();
    ArrayList<Integer> resultCoef = new ArrayList<Integer>();

    @Override public String toString() { 
        // Return the readable string from Polynomial
        StringBuilder coefString = new StringBuilder();
        
        for (int i = 0; i < polynomial.size(); i++) {
            coefString.append(polynomial.get(i) + ", ");
        }
        return coefString.toString();
    }

    @Override public boolean equals(Object other) {
        if (this.polynomial.hashCode() != other.hashCode()) {
            return false;
        }
        else {
            if (this.compareTo((Polynomial)other) == 0) {
                return true;
            }
            else {
                return false;
            }
        } 
    }

    @Override public int hashCode() {
       return polynomial.hashCode();
    }

   
    public Polynomial(int[] coefficients) { // Parameterized Constructor 
        
        this.coefficients = coefficients;  
        int[] copyOfCoefficients = Arrays.copyOf(this.coefficients, this.coefficients.length);

        for(int j = 0; j < coefficients.length; j++) {
            polynomial.add(j, coefficients[j]);
        }
        for (int i = coefficients.length - 1; i > 0; i-- ) {
            if (coefficients[i] == 0) {
                polynomial.remove(i);
            }
            else {
                break;
            }
        }
    } 

    // Returns the degree of this polynomial
    public int getDegree() {  
        return polynomial.size() - 1; }  

    // Returns the coefficient for the term of order k.
    public int getCoefficient(int k) {   
        return polynomial.get(k); }

    // Evaluates the polynomial for the value x
    public long evaluate(int x) { 
        long result = 0;
        for (int i = 0; i < polynomial.size(); i++) {
            result += (Math.pow(x, i)) * polynomial.get(i);
        }
        return result;
    }
    
    // Returns the size of the polynomial
    public int getLength() {  
          return polynomial.size(); }  

    public Polynomial add(Polynomial other) { 
        int x, y;
            
        if(other.getLength() < polynomial.size()) { 
            for(x = 0; x < other.getLength(); x++) {
                resultCoef.add(other.getCoefficient(x) + polynomial.get(x));
            }
            for(y = x; y < polynomial.size(); y++) {
                resultCoef.add(polynomial.get(y));
            }     
        }
        else {
            for(x = 0; x < polynomial.size(); x++) {
                resultCoef.add(other.getCoefficient(x) + polynomial.get(x));
            }
            for(y = x; y < other.getLength(); y++) {
                resultCoef.add(other.getCoefficient(y));
            }                
        }
        Polynomial testPol = new Polynomial(convertIntegers(resultCoef));
        return testPol;
    }

    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public Polynomial multiply(Polynomial other) {
        
        int sizeOther = other.getLength();
        int sizeNewCoef = polynomial.size();

        int[] multPoly = new int[sizeOther + sizeNewCoef - 1];

        for(int i = 0; i < (sizeOther + sizeNewCoef - 1); i++) {
            multPoly[i] = 0;
        }
        for(int i = 0; i < sizeNewCoef; i++) {
            for(int j = 0; j < sizeOther; j++){
                multPoly[i + j] += polynomial.get(i) * other.getCoefficient(j); 
            }
        }
        Polynomial prodPoly = new Polynomial(multPoly);
        return prodPoly;
    }

    public int compareTo(Polynomial other) {

        if(other.getDegree() == polynomial.size()-1) {
            for(int i = other.getDegree(); i >= 0; i--){
                int v1 = this.polynomial.get(i);
                int v2 = other.polynomial.get(i);
                if(v1 > v2) {return +1;}
                if(v2 > v1) {return -1;}
            }
            return 0;
        }
        else if(other.getDegree() > polynomial.size()-1) {
            return -1;
        }
        else {
            return 1;
        }
    }
}