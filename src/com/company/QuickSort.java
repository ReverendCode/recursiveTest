package com.company;

/**
 * Created by Code on 7/15/14.
 *
 * This class will automatically sort an array of integers that is passed to it using a quicksort algorithm
 */
public class QuickSort {
    private int[] theArray;
    private int arraySize;

    public QuickSort(int[] array) {
        theArray=array;
        arraySize=theArray.length;
    }

    private void recursiveSort(int left,int right) {

if (arraySize<=3) sortManually(left, right);
        else {
    long middleValue = findMedian(left,right);
        }
    }

    private void sortManually(int left, int right) {

    }

    private long findMedian(int left, int right) {
        int centerIsh = (left+right)/2; //get a location near the middle of the array

        if (theArray[left]> theArray[centerIsh]) swap (left, centerIsh);
        if (theArray[left]> theArray[right]) swap(left,right);
        if (theArray[right]> theArray[centerIsh]) swap(right,centerIsh);

        return 0;
    }
    public String displayList () {
        String output ="";
        int counter = 0;
        for (int i=0;i<arraySize;i++) {
            output += theArray[i] + " ";
            if (++counter == 10) {
                counter=0;
                output+="\n";
            }

        }
        return output;
    }

    private void swap(int left, int right) {
        int temp = left;
        left = right;
        right = temp;
    }
}
