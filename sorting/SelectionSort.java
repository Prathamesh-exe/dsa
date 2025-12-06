import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
    private static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i=0;i<n-1;i++){
            //find the minimum element in unsorted array
            int minIdx=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIdx]){
                    minIdx=j;
                }
            }
            //swap the found minimum element with the first element
            int temp=arr[minIdx];
            arr[minIdx]=arr[i];
            arr[i]=temp;
        }

    }
}
