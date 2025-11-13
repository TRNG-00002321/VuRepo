package com.revature.Main;
import com.revature.Assignment.TwoDArray;

public class MainMethod {
    public static void main(String[] args) {
        TwoDArray obj = new TwoDArray();
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] arr5 = {
                {2,3,1},
                {5,4,6},
                {7,8,9}
        };
        obj.printArray(arr);
        int sum = obj.sumArray(arr);
        System.out.printf("The sum is %d", sum);
        System.out.println();
        int max = obj.maxValue(arr);
        System.out.printf("The max value is %d", max);
        System.out.println();
        int[] arr1 = obj.sumRow(arr);
        System.out.println("The sum of rows are: ");
        for(int i=0;i<arr1.length;i++){
            System.out.printf("%d",arr1[i]);
            System.out.println();
        }
        int [] arr2 = obj.sumColumn(arr);
        System.out.println("The sum of columns are: ");
        for(int i=0;i<arr2.length;i++){
            System.out.printf("%d",arr2[i]);
            System.out.println();
        }
        System.out.println("The transposed array is: ");
        int[][] arr3 = obj.transpose(arr);
        for(int i=0;i<arr3.length;i++){
            for(int j=0;j<arr3[i].length;j++){
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println();
        }
        int[][] arr4 = obj.matrixAddition(arr, arr5);
        System.out.println("The sum of the two matrices is: ");
        for(int i=0;i<arr4.length;i++){
            for(int j=0;j<arr4[i].length;j++){
                System.out.print(arr4[i][j]+" ");
            }
            System.out.println();
        }
    }
}
