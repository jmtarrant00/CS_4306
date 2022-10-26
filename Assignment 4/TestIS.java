// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  4
// IDE:         Visual Studio Code

import java.util.*;

public class TestIS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput;
        boolean run = true;

        while(run){
            Menu();
            userInput = input(input);
            switch(userInput){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
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
    }

    static void Menu(){
        System.out.print("\n---------------MAIN MENU---------------\n"
                       + "1. Create and display array Values[]\n"
                       + "2. Read output table size\n"
                       + "3. Run algorithm and display outputs\n"
                       + "4. Exit program\n"
                       + "\nEnter option number: ");
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
}
