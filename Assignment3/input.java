package Assignment3;

import java.util.Scanner;

class input {
    
    public int getInput(Scanner input){
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
