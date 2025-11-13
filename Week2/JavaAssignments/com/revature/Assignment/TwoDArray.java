package com.revature.Assignment;

public class TwoDArray {
    // Print a 2D Array:
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            ;
        }
    }
    // Calculate the sum of all elements in a 2D array.
    public static int sumArray(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum+=arr[i][j];
            }
        }
        return sum;
    }
    // Find the maximum element within a 2D array.
    public static int maxValue(int[][] arr){
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if(arr[i][j]>max){
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    // Calculate the sum of elements for each individual row
    public static int[] sumRow(int[][] arr){
        int [] arr1 = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            arr1[i] = sum;
        }
        return arr1;
    }
    // Calculate the sum of elements for each individual column
    public static int[] sumColumn(int[][] arr){
        int [] arr2 = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[j][i];
            }
            arr2[i] = sum;
        }
        return arr2;
    }
    // Transpose Matrix
    public static int[][] transpose(int[][] arr){
        int [][] transpose = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j=0;j<arr[i].length;j++){
                transpose[j][i]=arr[i][j];
            }
        }
        return transpose;
    }
    // Matrix Addition:
    public static int[][] matrixAddition(int[][] arr1, int[][] arr2){
        int [][] arr = new int[arr1.length][arr1[0].length];
        for (int i = 0; i<arr1.length;i++){
            for(int j = 0;j<arr1[i].length;j++){
                arr[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        return arr;
    }
}
