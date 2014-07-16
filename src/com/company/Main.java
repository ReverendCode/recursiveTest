package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
System.out.print("testing 4^9. should be 262144: "+Power(4,9));
       int[] newArray = new int[21];//create new array of integers
        fillArray(newArray,100);//fill with random numbers up to 100
        QuickSort theArray = new QuickSort(newArray);//pass the array to a new QuickSort object, for manipulation
        System.out.println();
        System.out.println(theArray.displayList());
        System.out.println("\nDisplay the median value: "+theArray.getMedianValue(0,20));
        System.out.println("Now show the partially sorted list, The median value should be in location number 11.\n"+theArray.displayList());
//on the second display, everything before position 11 should be less than, and everything after should be greater than

    }

    public static int Power (int base, int exp) {
        if (exp==0) return 1; //included for sake of completeness
        if (exp==1) return base; //if exp is 1, you have reached the end of this recursive function, so return.
        if ((exp & 1)==0) {//check for even exponent     *Note* this idea came from stackOverflow, if not the exact syntax.
            base *=base; //base * base
            exp /=2;
            return Power(base, exp);
        }
        else { //deal with odd exponents
            int oldbase = base;
            base = base*base;
            exp = (exp-1)/2;
            return oldbase*Power(base,exp);
        }
    }

    public static void fillArray(int[] array, int maxValue) {
        for (int i=0;i<array.length;i++) {
            array[i]= (int) (Math.random()*maxValue+1);
        }
    }

}
