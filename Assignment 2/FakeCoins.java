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
 *  Algorithm Pseudocode Syntax
 *      
 */

//Code Section

//Imports
import java.util.*;

public class FakeCoins {
    public static void main(String []args){
        boolean run = true;
        int userInput = 0;
        int stackCount = 0;
        List<Integer> stacks = new ArrayList<Integer>();
        while(run){
            Menu();
            userInput = input();
            System.out.print(userInput);
            // break;
            switch(userInput){
                case 1:
                    System.out.print("Please Input the number of stacks: ");
                    stackCount = input();
                    // for(int i = 0; i < stackCount; i++){
                    //     stacks.add();
                    // }
                    break;
                case 2:
                    System.out.print("Please input the weight of each Stack: ");
                    getWeights(stacks, stackCount);
                    System.out.println(stacks);
                    break;
                case 3:
                    System.out.println("Finding Fake Stack...");
                    findFake(stacks);
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
            }
        }

    }
    
    public static int input(){
        Scanner input = new Scanner(System.in);
        boolean isInt = false;
        int userInput = 0;
        while (!isInt){
            if (input.hasNextLine()){
                userInput = input.nextInt();
                System.out.println("Inside For: " + userInput);
                isInt = true;
            } else {
                System.out.println("Please input an integer");
            }
            input.nextLine();
        }
        System.out.println("User Input: " + userInput);
        input.close();
        return userInput;
    }

    public static void Menu() {
        System.out.print("\n-----------------MAIN MENU-------------- \n"
                            + "1. Read number of stacks/coins per stack \n"
                            + "2. Read coin weight in each stack (10 or 11 grams) \n"
                            + "3. Run algorithm and display output \n"
                            + "4. Exit Program \n"
                            + "\nEnter Option Number: ");
    }

    public static List<Integer> getWeights(List<Integer> stacks, int stackCount){
        for (int i = 0; i < stackCount; i++){
            System.out.print("What is the weight of the coins in stack " + i + 1 + "?");
            stacks.add(Integer.valueOf(input()));
        }
        return stacks;
    }

    public static int findFake(List<Integer> stacks) {
        return 0;
    }
}