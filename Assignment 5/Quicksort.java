// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  5
// IDE:         Visual Studio Code


public class Quicksort {
    //Initialize Variables for class
    private int low = 0, high = 1;
    private int[] array;
    private long compCount = 0;
    
    //Constructor
    public Quicksort(){
    }

    //Setter for the array
    public void setArray(int[] array){
        //set this.array to array so that we don't mess up the original array since it has to be used again by the other sorts
        this.array = array;
        this.high = array.length - 1;

        //Call Quicksort using the variables local to this object 
        QS(this.array, this.low, this.high);

    }

    /*This function finds the correct position for the pivot element
     * by first setting the pivot to the last element in the array, then finding the correct position for it.
     * This is done by placing all the smaller elements to the left of the pivot and all the larger elements to
     * the right of the pivot
     * 
     * Input: Array to be sorted, the position of the low element (starting index), and the position of the high element (ending index)
     * Output: position of the pivot for the next pass through the array
     */
    
    private int partition(int[] array, int low, int high){
        //Initialize variables
        int temp = 0;
        int pivot = array[high]; //set the pivot to the last element in the array
        int i = (low - 1); //set index of smallest element
        for (int j = low; j < high; j++){
            if (array[j] <= pivot){ //check if current element is smaller than the pivot. 
                //if current element is smaller than the pivot, swap it with the current smallest element
                compCount++;
                i++; //increase position of smallest element
                //swap smallest element with current element
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //swap smallest element and pivot
        temp = array[i+1];
        array[i+1] = high;
        array[high] = temp;

        //return position for pivot element
        return (i + 1);
    }

    /*This function runs the quicksort. checks to make sure that the low value isn't higher than high value, 
     *  then runs the sort. First it finds the pivot of the current array, then divides the array into two 
     *  parts around the pivot and recursively calls the sort on each part of the array
     * 
     * Input: Array of n elements to be sorted, and the low (start index) and high (end index) positions of the array
     * Output: Sorted array 
     */
    private void QS(int[] array, int low, int high){
        if (low < high){
            int pivot = partition(array, low, high);

            QS(array, low, pivot - 1);
            QS(array, pivot + 1, high);
        }
    } 

    // getter for quicksort comparison count
    public long getCompCount(){
        return compCount;
    }
}
