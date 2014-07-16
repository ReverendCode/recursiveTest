package com.company;

/**
 * Created by Code on 7/15/14.
 *
 * This class will automatically sort an array of integers that is passed to it using a quicksort algorithm
 */
public class QuickSort {
    private int[] theArray;
    private int arraySize;
    private int centerAddress;

    public QuickSort(int[] array) {
        theArray=array;
        arraySize=theArray.length;
        centerAddress = arraySize/2;
    }

    public int getMedianValue(int left,int right) {//*NOTE* array is being ordered small to large, left to right
        if (arraySize<=3)  manualMedianReturn(left, right);
        else {
            int pivotValue = findPivotValue(left,right);
            int pivotLocation = setPartition(left,right,pivotValue);
            if (pivotLocation==centerAddress) return theArray[centerAddress];//if the center address has been ordered, return
            if (pivotLocation<centerAddress) return getMedianValue(pivotLocation,right);//otherwise, keep sorting towards the centerAddress
            if (pivotLocation>centerAddress) return getMedianValue(left,pivotLocation);
        }
        return theArray[centerAddress];
    }

    private int setPartition(int left, int right, int pivotValue) {
        int leftMarker = left;
        int rightMarker = right-1;
        while(true) {
            while (theArray[++leftMarker]<pivotValue) ;
            while (theArray[--rightMarker]>pivotValue) ;
            if (leftMarker>=rightMarker) break;
            else swap(leftMarker,rightMarker);
        }
        swap(leftMarker,right-1);
        return leftMarker;
    }

    private void manualMedianReturn(int left, int right) {
        if (theArray.length <=1) return; //if there is only one item, it has to be the median.

       if (theArray.length == 2){
           if (theArray[left]>theArray[right])swap(left,right);
           return;
       }

        if (theArray[left]>theArray[right-1]) swap(left,right-1);
        if (theArray[left]>theArray[right]) swap(left,right);
        if (theArray[right-1]>theArray[right]) swap(right-1,right);
    }

    private int findPivotValue(int left, int right) {
        int centerIsh = (left+right)/2; //get a location near the middle of the array

        if (theArray[left]> theArray[centerIsh]) swap (left, centerIsh);
        if (theArray[left]> theArray[right]) swap(left,right);
        if (theArray[right]< theArray[centerIsh]) swap(right,centerIsh);
        swap(centerIsh,right-1); //set pivot
        return theArray[right-1];
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

        int temp = theArray[left];
        theArray[left]=theArray[right];
        theArray[right]=temp;

    }
}
