
/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_lab6;


/**
 * Create methods for insertion sort, merge sort,
 * heap sort and quick sort. 
 * @author SAM Borhan
 * @version 01
 */
public class Sort {

	/* *** method to sort array using insertion sort ****/
    public void insertionSort(int arr[]) { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 

	/* ******* method to sort array using heap sort ********/
    public void heapSort(int arr[]) { 
        int n = arr.length; 
  
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        for (int i=n-1; i>=0; i--) { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
              heapify(arr, i, 0); 
        } 
    } 
  
    /* private helper method*/
    private void heapify(int arr[], int n, int i) { 
        int largest = i; 
        int l = 2*i + 1;  
        int r = 2*i + 2; 
  
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
              heapify(arr, n, largest); 
        } 
    } 
  
	
	 /* ******* method to sort array using quick sort ********/
    public int[] quickSort(int[] array) {
	        
	        qSort(array, 0, array.length - 1);
	        return array;
	    }

	   /* helper method for quickSort*/
	    private void qSort(int[] array, int left, int right) {
	        if (left >= right) {
	            return;
	        }
	        int pivot = array[(left + right)/2];
	        int index = partition(array, left, right, pivot);

	        qSort(array, left, index - 1);
	        qSort(array, index, right);
	 }
		   
	    /* helper method for quickSort*/
	private int partition(int[] array, int left, int right, int pivot) {
	        while (left <= right) {
	            while(array[left] < pivot) {
	                left++;
	            }

	            while (array[right] > pivot) {
	                right--;
	            }

	            if (left <= right) {
	                swap(array, left, right);
	                left++;
	                right--;
	            }
	        }

	        return left;
	 }

	   /* helper method */
	private void swap(int[] array, int left, int right) {
	        int temp = array[left];
	        array[left] = array[right];
	        array[right] = temp;
	}

	
	 	/* ****** method to sort array using merge sort  ******/
    public void mergeSort(int arr[], int l, int r){
         if (l < r) {
            int m = (l+r)/2;

            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            mSort(arr, l, m, r);
        }
     }

       /*helper method*/
    private void mSort(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
}
