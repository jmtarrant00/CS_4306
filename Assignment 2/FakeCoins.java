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
import java.util.Scanner;


public class FakeCoins {
    public static void main(String []args){
        int test = input();
        System.out.println(test);
    }
    public static int input(){
        Scanner input = new Scanner(System.in);
        boolean isInt = false;
        int userInput = 0;
        while (!isInt){
            if (input.hasNextInt()){
                userInput = input.nextInt();
            }
        }
        input.close();
        return userInput;
    }
}