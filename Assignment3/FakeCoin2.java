package Assignment3;

import java.util.Scanner;

public class FakeCoin2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userInput = 0;

        while(run){
            Menu();
            userInput = input(input);
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
}
