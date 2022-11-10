
public class Mergesort {
    private int right, left = 0, middle;
    private int[] array;
    private int compCount = 0;

    public Mergesort(){

    }

    public void setArray(int[] array){
        this.array = array;
        this.right = array.length - 1;

        MS(this.array, this.left, this.right);
    }

    // Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge1(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
				compCount++;
			}
			else {
				arr[k] = R[j];
				j++;
				compCount++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge1(arr, l, m, r);
		}
	}

	// // /* A utility function to print array of size n */
	// // static void printArray(int arr[])
	// // {
	// // 	int n = arr.length;
	// // 	for (int i = 0; i < n; ++i)
	// // 		System.out.print(arr[i] + " ");
	// // 	System.out.println();
	// // }

	// // Driver code

    private void merge(int[] array, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++){
            leftArr[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++){
            rightArr[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2){
            if (leftArr[i] <= rightArr[j]){
                array[k] = leftArr[i];
                i++;
                compCount++;
            } else {
                array[k] = rightArr[j];
                j++;
                compCount++;
            }
            k++;
        }

        while (i < n1){
            array[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2){
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private void MS(int[] array, int left, int right){
        if (left < right){
            middle = left + (right - 1) / 2;

            MS(array, left, middle);
            MS(array, middle+1, right);

            merge(array, left, middle, right);
        }
    }

    public int getCompCount(){
        return compCount;
    }
}
