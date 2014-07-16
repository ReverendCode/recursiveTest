package com.company;

public class Main {

    public static void main(String[] args) {
System.out.print("testing 4^9. should be 262144: "+Power(4,9));



    }

    public static int Power (int base, int exp) {
        if (exp==0) return 1; //don't know if I need this, but just in case
        if (exp==1) return base; //if exp is 1, you have reached the end of this recursive function, so return.
        if ((exp & 1)==0) {//check for even exp *Note* this idea came from stackOverflow, if not the exact syntax.
            base = base * base; //base * base
            exp = exp/2;     //exp / 2
            return Power(base, exp);
        }
        else { //deal with odd exponents
            int oldbase = base;
            base = base*base;
            exp = (exp-1)/2;
            return oldbase*Power(base,exp);
        }
    }


}
