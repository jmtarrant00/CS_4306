// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  3
// IDE:         Visual Studio Code

/*Algorithm Design Block
 * Logical Steps:
 *  Figuratively split array into 2 subarrays after first element
 *  Look at next element in array, and place in appropriate spot in beginning of array
 *  Repeat until sorted
 *       
 * Algorithm Pseudocode Syntax:
 *  First Sort:
 *      for i <- 1 to n-1 do 
 *          v <- A[i]
 *          j <- i-1
 *          while j >= 0 and A[j] > v do
 *              A[j+1] <- A[j]
 *              j <- j-1
 *          A[j+1] <- v
 * Second Sort:
 *      for i <- 1 to n-1 do
 *          j <- i-1
 *          while j >= 0 and A[j]>A[j+1] do
 *              swap(A[j], A[j+1])
 *              j <- j-1
 * 
 * While there is less code in the second sort algorithm, the swap operation adds more swaps, and thus doing the 
 *  swap manually is more intensive on the processor. 
 *      
 */

//Code Section

package Assignment3;

//Import for Scanner and ArrayList
import java.util.*;

public class InsertionCompare {
    public static void main(String[] args) {
        //Initialize Scanner
        Scanner input = new Scanner(System.in);

        //Declare Variables
        boolean run = true;
        int userInput;
        int arraySize = 0;
        ArrayList<Integer> sortArray = new ArrayList<Integer>(0);   //ArrayList for first sort
        ArrayList<Integer> sortArray2 = new ArrayList<Integer>(0);  //ArrayList for second sort

        //Main Sentinel Loop
        while (run){
            Menu(); //Print the menu
            userInput = input(input); //Get user input
            switch(userInput){
                case 1: //First Option
                    System.out.print("What is the size of the array? ");
                    arraySize = input(input); //Get input for the array size
                    break;
                case 2: //Second Option
                    sortArray = getVals(sortArray, arraySize, input); //Get the values to be sorted
                    sortArray2.addAll(sortArray);                     //Copy all values to second array
                    break;
                case 3: //Third Option
                    System.out.println("\nSorting array...\n");
                    System.out.println("Array size: " + arraySize);
                    System.out.print("Array Values: ");
                    for (int i = 0; i < arraySize; i++){
                        System.out.print(sortArray.get(i) + " ");
                    }
                    InsertSort1(sortArray);  //Run first sort
                    InsertSort2(sortArray2); //Run second sort
                    break;
                case 4: //Fourth Option
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default: //Default case
                    System.out.println("Please input a valid menu option (1-4)");
                    break;
            }
        }
        input.close();
    }

    /*Print out Main Menu
     * Input: None
     * Output: Main Menu printed in console
     */
    static void Menu(){ 
        System.out.print("\n-------------MAIN MENU--------------\n"
                         + "1. Read Array Size\n"
                         + "2. Read Array Values (integer type)\n"
                         + "3. Run Algorithm and Display Results\n"
                         + "4. Exit Program\n\n"
                         + "Enter option number: ");
    }

    /*Take user input and make sure it's an integer
     * Input: scanner
     * Output: integer to be used for input
     */
    static int input(Scanner input){
        // int userInput = 0;
        while(!input.hasNextInt()) { //Checks if the entered input is an integer
            input.next();
            System.out.println("Please enter an Integer");
            System.out.print("Enter Option Number: "); 
        }
        int userInput = input.nextInt(); //Get int input
        return userInput;
    }

    /*Add all the values to the arrayList
     * Input: ArrayList for storing the values, size of the list, and a scanner
     * Output: ArrayList that contains user defined values
     */
    static ArrayList<Integer> getVals(ArrayList<Integer> sortArray, int arraySize, Scanner input){
        sortArray.removeAll(sortArray);
        for (int i = 0; i < arraySize; i++){
            System.out.print("What is the value at position " + (i+1) + "? ");
            sortArray.add(input(input));
        };

        return sortArray;
    }

    /*Do the first insertion sort
     * Input: arraylist containing values to be sorted
     * Output: Prints string containing stats about the sorting of the array
     */
    static void InsertSort1(ArrayList<Integer> sortArray){
        int length = sortArray.size(); //get size of array
        int v, j, count = 0; //Initialize variables

        for (int i = 1; i < length - 1; i++){ //Interate over the array from the second element to the second to last element
            v = sortArray.get(i); //get second element
            j = i - 1; //set j to help get element before v
            while (j >= 0 && sortArray.get(j) > v){ //run while j isn't less than 0 and previous element is less than v
                sortArray.set(j+1, sortArray.get(j)); //swap element at index j+1 (i) with element at index j
                count++; //increment counter
                j--;
            }
            sortArray.set(j+1, v);
        }

        System.out.println("\nInsertionSort1 Stats:\n"
                         + "      j >= 0:          " + count + "\n"
                         + "      A[j] > v:        " + count + "\n"
                         + "      A[j+1] = A[j]:   " + count + "\n"
                         + "      j = j - 1:       " + count + "\n");

        return;
    }

    /*Do the second insertion sort
     * Input: arraylist containing values to be sorted
     * Output: Prints string containing stats about the sorting of the array
     */
    static void InsertSort2(ArrayList<Integer> sortArray){
        //Initialize Variables
        int j, count = 0;

        for (int i = 1; i < (sortArray.size() - 1); i++){ //Iterate over the array starting at second element to second to last element
            j = i - 1;
            while (j >= 0 && sortArray.get(j) > sortArray.get(j+1)){ //run while j isn't less than 0 and j is greater than next element
                Collections.swap(sortArray, j, j+1); //swap element j and next element
                count++; //increment counter
                j--;
            }
        }

        System.out.println("InsertionSort2 Stats:\n"
                         + "      j >= 0:          " + count + "\n"
                         + "      A[j] > A[j+1]    " + count + "\n"
                         + "      Swap:            " + (count * 3) + "\n"
                         + "      j = j - 1:       " + count + "\n");
    }
}
