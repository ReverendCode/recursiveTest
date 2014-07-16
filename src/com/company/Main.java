package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("testing 4^9. Should be 262144: "+Power(4,9));
        System.out.println("Testing 2^3. Should be 8: "+Power(2,3));
        System.out.println("Testing 3^12. Should be 531441: "+Power(3,12));
        System.out.println("Testing 11^0. Should be 0: "+Power(11,0));
        System.out.println("Testing 12^1. Should be 12: "+Power(12,1));
        System.out.println("Testing 1^99. Should be 1: "+Power(1,99));




        int[] newArray = new int[21];//create new array of integers
        fillArray(newArray,100);//fill with random integers from -100 to 100
        QuickSort theArray = new QuickSort(newArray);//pass the array to a new QuickSort object, for manipulation
        System.out.println();
        System.out.println(theArray.displayList());
        System.out.println("\nDisplay the median value: "+theArray.getMedian());
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
            array[i]= (int) (Math.random()*(maxValue*2)-maxValue+1);
        }
    }


    //sample recursive binary search
    private static boolean recBinarySearch(int[] theArray, int lookFor, int lower, int upper) {

        int midPoint = (lower+upper)/2;
        if (theArray[midPoint]==lookFor) return true;
        if (lower > upper) return false;
        if (theArray[midPoint]<lookFor) return recBinarySearch(theArray,lookFor,lower,midPoint-1);
        else return recBinarySearch(theArray,lookFor,midPoint+1,upper);
    }

}
