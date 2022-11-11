// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  5
// IDE:         Visual Studio Code

public class Heapsort {
    //initialize variables
    private int[] array;
    private int compCount = 0;

    //Constructor
    public Heapsort(){
    }

    //setter for array
    public void setArray(int[] array){
        //set this.array to array to preserve original array for other sorts
        this.array = array;

        //call Heapsort with variable local to this object
        HS(this.array);
    }

    private void heapify(int[] array, int n, int i){
        //initialize variables. set largest to the root 
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int swap;

        //check if the left child of the root is larger than the root
        if (left < n && array[left] > array[largest]){
            largest = left;
            compCount++;
        }

        //check if the right child of the root is larger than the root
        if (right < n && array[right] > array[largest]){
            largest = right;
            compCount++;
        }

        //if the largest isn't the root, swap it with the largest
        if (largest != i){
            compCount++;
            swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            //reheapify to place the original root in the correct spot
            heapify(array, n, largest);
        }
    }

    /*Main function for heapsort. Organizes the array into a heap and calls the heapify function
     * 
     * Input: array of n elements
     * Output: Sorted array
     */
    private void HS(int[] array){
        //initialize variables
        int n = array.length;
        int temp;

        //Reorganize array into a heap
        for (int i = (n/2-1); i >= 0; i--){
            heapify(array, n, i);
        }

        //sort the array. Pull one element off the heap and put at root
        for (int i = n-1; i > 0; i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //reheapify the heap now that the top element is removed
            heapify(array, i, 0);
        }
    }

    //getter for comp count
    public int getCompCount(){
        return compCount;
    }
}
