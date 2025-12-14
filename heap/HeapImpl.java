import java.util.*;
public class HeapImpl {
    public static void main(String[] args) {
        int[] heap = {3, 5, 8, 4, 10, 12};
        System.out.println("Original Heap: " + Arrays.toString(heap));

        // Add element to heap
        int newElement = 2;
        heap = Arrays.copyOf(heap, heap.length + 1);
        heap[heap.length - 1] = newElement;
        HeapifyUp(heap, heap.length - 1);
        System.out.println("Heap after adding " + newElement + ": " + Arrays.toString(heap));

        // Remove element from heap
        heap[0] = heap[heap.length - 1];
        heap = Arrays.copyOf(heap, heap.length - 1);
        HeapifyDown(heap, 0);
        System.out.println("Heap after removing root: " + Arrays.toString(heap));       
    }
    
    //remove element from heap
    public static void HeapifyDown(int[] heap, int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.length && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < heap.length && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(heap, index, smallest);
            HeapifyDown(heap, smallest);
        }
    }

    //helper method to swap elements
    public static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    //add element to heap
    public static void HeapifyUp(int[] heap, int index) {
        if (index == 0) return; // Reached the root

        int parentIndex = (index - 1) / 2;
        if (heap[index] < heap[parentIndex]) {
            swap(heap, index, parentIndex);
            HeapifyUp(heap, parentIndex);
        }
    }
}