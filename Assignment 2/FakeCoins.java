// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  2
// IDE:         Visual Studio Code

/*Algorithm Design Block
 * Logical Steps:
 *  Examine weight of all stacks
 *  Determine which stack has the weight of the fake coins
 *      To do this, search through the stacks and return the one 
 *      who's coin weight == 11 
 * 
 * Algorithm Pseudocode Syntax:
 *  // Searchs for a stack of fake coins
 *  // Input: ArrayList of weights for coin stacks
 *  // Output: Position of stack of fake coins
 *      for index ← 0 to stacks.length
 *          numWeighs ← numWeighs + 1
 *          if stacks[i] = 11
 *              arr[0] ← index
 *              arr[1] ← numWeighs
 * 
 *  Minimum Number of Weighings:
 *      1 weighing. This is the best case scenario where the stack 
 *      of fake coins is the first stack in the list
 *      
 */

//Code Section

//Import for Scanner and ArrayList
import java.util.*;

public class FakeCoins {
    public static void main(String []args){
        //Create Scanner object for inputs
        Scanner input = new Scanner(System.in);

        //Varable declarations
        boolean run = true;
        int userInput = 0;
        int stackCount = 0;
        ArrayList<Integer> stacks = new ArrayList<Integer>(0); //ArrayList to hold the weights of the stacks
        int[] funcReturn; //Array for holding the results of the algoritm
        while(run){
            Menu();
            userInput = input(input); //Take input for Menu
            switch(userInput){
                case 1: //First menu Item
                    System.out.print("Please Input the number of stacks: ");
                    stackCount = input(input); //Get number of stacks 
                    break;
                case 2: //Second Menu Item
                    System.out.println("\nPlease input the weight of each Stack: \n");
                    getWeights(stacks, stackCount, input);  //Get the weight of all the stacks
                    break;
                case 3: //Third Menu Item
                    System.out.println("\nFinding Fake Stack...\n");
                    funcReturn = findFake(stacks); //Algorithm Function Call

                    System.out.println("Total Number of Stacks is:    " + stackCount + "\n"
                                        + "Fake Coins Stack is stack #:  " + funcReturn[0] + "\n"
                                        + "# of weighings required:      " + funcReturn[1]);
                    break;
                case 4: //Fouth Menue Item
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default: //Default in case user enters a non-menu number
                    System.out.println("Please Input a value between 1 and 4");
                    break;
            }
        }
        input.close();

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

    public static void Menu() { //Print out Main Menu
        System.out.print("\n-----------------MAIN MENU-------------- \n"
                            + "1. Read number of stacks/coins per stack \n"
                            + "2. Read coin weight in each stack (10 or 11 grams) \n"
                            + "3. Run algorithm and display output \n"
                            + "4. Exit Program \n"
                            + "\nEnter Option Number: ");
    }

    public static ArrayList<Integer> getWeights(ArrayList<Integer> stacks, int stackCount, Scanner input){
        int weight = 0; //Variable to store weight while checking the value
        for (int i = 0; i < stackCount; i++){
            while (true){
                System.out.print("What is the weight of the coins in stack " + (i + 1) + " in grams? ");
                weight = input(input); //Take input weight
                if (weight == 11 && !stacks.contains(11)){ //If input is 11, check if it's already in the ArrayList
                    stacks.add(weight); //Add to ArrayList
                    break;
                } else if(weight == 10) { //Add to list if value is 10
                    stacks.add(weight); 
                    break;
                } else if (weight == 11 && stacks.contains(11)){ //If value is 11 and 11 is already in list, tell user only one can be in list
                    System.out.println("Only one stack can weigh 11 grams");
                } else { //If value is not 10 or 11, Tell user weights can only be 10 or 11
                    System.out.println("Please input either 10 or 11 grams");
                }
            }
        }
        return stacks;
    }

    public static int[] findFake(ArrayList<Integer> stacks) {
        int numWeighs = 0; //Store number of iterations through loop
        int[] funcReturn = {0, 0}; //Array to pass both fake coin index and number of weighs
        for (int index = 0; index < stacks.size(); index++){
            numWeighs++;
            if (stacks.get(index) == 11){ //Check to see if the current stack being looked at has a weight of 11
                funcReturn[0] = index + 1;
                funcReturn[1] = numWeighs;
                return funcReturn; //Return results back to main()
            }
        } 
        return funcReturn; //Return {0, 0} if there are no stacks with 11 coins

    }
}