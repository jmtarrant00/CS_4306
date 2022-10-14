import java.util.*;

public class InsertionCompare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userInput;
        int arraySize = 0;
        // ArrayList<Integer> sortArray;
        int[] sortArray;

        while (run){
            Menu();
            userInput = input(input);
            switch(userInput){
                case 1:
                    System.out.print("What is the size of the array? ");
                    arraySize = input(input);
                    break;
                case 2:
                    sortArray = new int[arraySize];
                    for (int i = 0; i < sortArray.length; i++){
                        sortArray[i] = input(input);
                    }
                    // getVals(sortArray, arraySize, input);
                    break;
                case 3:
                    System.out.println("\nSorting array...\n");
                    break;
                case 4: 
                    break;
                default:
                    break;
            }
        }
        input.close();
    }

    /*Print out Main Menu
     * Input: None
     * Output: Main Menu printed in console
     */
    public static void Menu(){ 
        System.out.print("\n-------------MAIN MENU--------------\n"
                         + "1. Read Array Size\n"
                         + "2. Read Array Values (integer type)\n"
                         + "3. Run Algorithm and Display Results\n"
                         + "4. Exit Program\n\n"
                         + "Enter option number: ");
    }

    public static int input(Scanner input){
        // int userInput = 0;
        while(!input.hasNextInt()) { //Checks if the entered input is an integer
            input.next();
            System.out.println("Please enter an Integer");
            System.out.print("Enter Option Number: "); 
        }
        int userInput = input.nextInt(); //Get int input
        return userInput;
    }

    public static int[] setSize(int[] sortArray, int arraySize){
        sortArray = new int[arraySize];
        return sortArray;
    }

    // public static int[] getVals(int[] sortArray, int arraySize, Scanner input){
    //     for (int i = 0; i < arraySize; i++){
    //         sortArray[i] = input(input);
    //     }
    //     return sortArray;
    // }
}
