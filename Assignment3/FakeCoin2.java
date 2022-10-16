package Assignment3;

import java.util.*;

public class FakeCoin2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userInput = 0, numCoins;

        while(run){
            Menu();
            userInput = input(input);
            switch(userInput){
                case 1:
                    System.out.print("How many coins are there? ");
                    numCoins = input(input);
                    break;
                case 2:

                case 3:
                case 4:
                default:
            }
        }
        

        input.close();
    }

    static void Menu(){
        System.out.print("\n-----------------MAIN MENU---------------------------\n"
                        + "1. Read number of coins (array size)\n"
                        + "2. Read array values (all values are 5 except one value 2)"
                        + "3. Run algorithm and display results"
                        + "4. Exit program"
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
            System.out.print("What is the value at position " + (i+1) + "? ");
            sortArray.add(input(input));
        };

        return sortArray;
    }
}
