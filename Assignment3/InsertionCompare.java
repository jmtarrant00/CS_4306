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
                    InsertSort1(sortArray);
                    InsertSort2(sortArray2);
                    break;
                case 4:
                    System.out.println("Exiting Program...");
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

    static ArrayList<Integer> getVals(ArrayList<Integer> sortArray, int arraySize, Scanner input){
        sortArray.removeAll(sortArray);
        for (int i = 0; i < arraySize; i++){
            sortArray.add(input(input));
        };

        return sortArray;
    }

    static void InsertSort1(ArrayList<Integer> sortArray){
        
    }

    static void InsertSort2(ArrayList<Integer> sortArray){

    }
}
