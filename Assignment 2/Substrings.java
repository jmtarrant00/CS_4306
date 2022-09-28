// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  2
// IDE:         Visual Studio Code

/*Algorithm Design Block
 * Logical Steps:
 *  Take input String
 *      Search through string until first A is found
 *      Find first B and get substring
 *      Find next substring using original A
 *      Once all substrings starting with original A are found, find next A
 *      Repeat process until all substrings are found
 *  
 * 
 * Algorithm Pseudocode Syntax:
 *  for index ← 0 to mainstring.length
 *      comparisons++
 *      if mainString[index] == 'A'
 *          for j ← index to mainString.length 
 *              comparisons++
 *              if mainString[j] == 'B'
 *                  numSubstrings++ 
 *      
 */

//Code Section

//Import for Scanner and ArrayList
import java.util.*;

public class Substrings {  
    public static void main(String[] args) {
        //Variable Initialization
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userInput = 0;
        String mainString = null;

        //Main program loop
        while(run){
            Menu(); //Display Menu
            userInput = input(input); //Get user input for menu option
            switch(userInput){ //Switch Case for menu options
                case 1: //First Menu Option
                    System.out.print("What is the input string? ");
                    mainString = input.next().toUpperCase(); //Get input string
                    break;
                case 2: //Second Menu Option
                    System.out.println("Finding Substrings...");
                    substring(mainString); //Function call to find substrings
                    break;
                case 3: //Third Menu Option
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default: //Default case if user inputs invalid number
                    System.out.println("Please input a valid menu option");
                    break;
            }
        }
        input.close(); //Close Scanner     
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
                            + "1. Read input string \n"
                            + "2. Run algorithm and display output (substrings and number of comparisons) \n"
                            + "3. Exit Program \n"
                            + "\nEnter Option Number: ");
    }

    /* This function searches for substrings of the input string
    *   Input: user input string
    *   Output: Print statement that contains the original string, 
    *       number of substrings, and number of comparisons
    */
    public static void substring(String mainString){
        //Variable initialization
        final char START = 'A', END = 'B'; //Deckare start and end chars
        int numSubstrings = 0, comparisons = 0; //For storing number of Substrings and comparisons
        for (int index = 0; index < mainString.length(); index++){ //Iterate over the string
            comparisons++;
            if (mainString.charAt(index) == START){ //If char @ index = A
                for (int j = index; j < mainString.length(); j++){ //Iterate over string after index
                    comparisons++;
                    if (mainString.charAt(j) == END) { //if char @ index j = B
                        numSubstrings++; //Increment substrings
                    }
                }
            }
        }
        //Print out results
        System.out.println("Input String:     " + mainString + "\n"
                            + "# of substrings:  " + numSubstrings + "\n"
                            + "# of comparisons: " + comparisons + "\n");
        return;
    }
    
}
