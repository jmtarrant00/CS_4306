package Assignment3;

import java.util.*;

public class InsertionCompare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userInput;
        int arraySize = 0;
        ArrayList<Integer> sortArray = new ArrayList<Integer>(0);
        ArrayList<Integer> sortArray2 = new ArrayList<Integer>(0);

        while (run){
            Menu();
            userInput = input(input);
            switch(userInput){
                case 1:
                    System.out.print("What is the size of the array? ");
                    arraySize = input(input);
                    break;
                case 2:
                    sortArray = getVals(sortArray, arraySize, input);
                    sortArray2.addAll(sortArray);
                    break;
                case 3:
                    System.out.println("\nSorting array...\n");
                    System.out.println("Array size: " + arraySize);
                    System.out.print("Array Values: ");
                    for (int i = 0; i < arraySize; i++){
                        System.out.print(sortArray.get(i) + " ");
                    }
                    InsertSort1(sortArray);
                    InsertSort2(sortArray2);
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default:
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

    static void InsertSort1(ArrayList<Integer> sortArray){
        int length = sortArray.size();
        int v, j, count = 0;

        for (int i = 1; i < length - 1; i++){
            v = sortArray.get(i);
            j = i - 1;
            while (j >= 0 && sortArray.get(j) > v){
                sortArray.set(j+1, sortArray.get(j));
                count++;
                j--;
            }
            sortArray.set(j+1, v);
        }

        System.out.println("\nInsertion Sort Stats:\n"
                         + "      j >= 0:          " + count + "\n"
                         + "      A[j] > v:        " + count + "\n"
                         + "      A[j+1] = A[j]:   " + count + "\n"
                         + "      j = j - 1:       " + count + "\n");

        return;
    }

    static void InsertSort2(ArrayList<Integer> sortArray){
        // Integer[] intArray = new Integer[sortArray.size()];
        // intArray = sortArray.toArray(intArray);
        int j, count = 0;

        for (int i = 1; i < (sortArray.size() - 1); i++){
            j = i - 1;
            while (j >= 0 && sortArray.get(j) > sortArray.get(j+1)){
                Collections.swap(sortArray, j, j+1);
                count++;
                j--;
            }
        }

        System.out.println("Insertion Sort Stats:\n"
                         + "      j >= 0:          " + count + "\n"
                         + "      A[j] > v:        " + count + "\n"
                         + "      A[j+1] = A[j]:   " + (count * 3) + "\n"
                         + "      j = j - 1:       " + count + "\n");
    }
}
