// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  6
// IDE:         Visual Studio Code

import java.util.Scanner;
public class DynamicHashing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        String question = "";

        while(run){
            Menu();
            question = "Enter Option Number: ";
            input(input, question);
        }
        
    }   
    
    /*Method to print the menu for user
     * Input: none
     * Output: Prints the menu in the console
     */
    static void Menu(){
        System.out.print("\n\n---------------MAIN MENU---------------\n"
                       + "1. Populate Arrays\n"
                       + "2. Run Algorithms\n"
                       + "3. Display outputs\n"
                       + "4. Exit program\n"
                       + "\nEnter option number: ");
    }

    /*Take user input and make sure it's an integer
     * Input: scanner
     * Output: integer to be used for input
     */
    static int input(Scanner input, String question){
        // int userInput = 0;
        while(!input.hasNextInt()) { //Checks if the entered input is an integer
            input.next();
            System.out.println("Please enter an Integer\n");
            System.out.print(question); 
        }
        int userInput = input.nextInt(); //Get int input
        return userInput;
    }

}
