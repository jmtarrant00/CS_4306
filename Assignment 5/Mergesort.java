// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  5
// IDE:         Visual Studio Code


public class Mergesort {
    //initialize variables
    private int right, left = 0;
    private int[] array;
    private long compCount = 0;

    //Constructor for class
    public Mergesort(){
    }

    //setter for array 
    public void setArray(int[] array){
        //set array to this.array so that the original array remains unchanged and can be used again for other sorts
        this.array = array;
        this.right = array.length - 1;

        //Call mergesort using variables local to this object
        MS(this.array, this.left, this.right);
    }

    /*Sorts and merges the sub arrays. Given an array, an start, middle, and end index from the main MS function, 
     *  the function splits the array into start->middle and middle+1->end. It then merges these arrays by placing 
     *  the elements in the correct position in the original array
     * 
     * Input: array containing n elements, start index, middle index, and end index
     * Output: sorted array  
     */
    private void merge(int[] array, int left, int middle, int right){
        //given start, middle and end indexes, find the size of the subarrays for this iteration of the merge
        int n1 = middle - left + 1; //array 1
        int n2 = right - middle; //array 2

        //create temp arrays using sizes found earlier
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        //copy elements from main array into the two subarrays
        for (int i = 0; i < n1; i++){
            leftArr[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++){
            rightArr[j] = array[middle + 1 + j];
        }

        //create indexes of the subarrays
        int i = 0, j = 0;

        //create initial index of merged arrays
        int k = left;
        while (i < n1 && j < n2){ //loop through both arrays
            if (leftArr[i] <= rightArr[j]){ 
                //if the element int left[i] is smaller than right[j], put the left[i] element in the main array at pos k
                array[k] = leftArr[i];
                i++; //increase index for left array
                compCount++;
            } else {
                //if right[j] is smaller than left[i], place right[j] in main array at pos k
                array[k] = rightArr[j];
                j++; //increase index for right array
                compCount++;
            }
            k++; //increase position for merged array
        }

        //copy any remaining elements of leftArr to merged array
        while (i < n1){
            array[k] = leftArr[i];
            i++;
            k++;
        }

        //copy any remaining elements of rightArr to merged array
        while (j < n2){
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /*Main function for MergeSort. Finds the middle index, then recursively calls itself on the smaller portions
     *  of the array using middle index
     * 
     * Input: array of n elements, first and last index
     * Output: sorted array
     */
    private void MS(int[] array, int left, int right){
        if (left < right){
            int middle = left + (right - left) / 2;

            MS(array, left, middle);
            MS(array, middle+1, right);

            merge(array, left, middle, right);
        }
    }

    //Getter for compCount
    public long getCompCount(){
        return compCount;
    }
}
