// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  3
// IDE:         Visual Studio Code

/*Algorithm Design Block
 * Logical Steps:
 *  Divide stack into 3 subcoins and get weight of each substack
 *  Since the real coins weigh 5, if the total weight of a substack
 *      isn't evenly divisible by 5, the fake coin is in that substack
 *  Once substack with fake coin is determined, recursively call the 
 *      algorithm on the fake coin stack
 * 
 * Question A)
 *  len <- numCoins / 3
 * 
 *  if coins.size = 1 OR coins[0] < 5 
 *      return
 * 
 *  if numCoins % 3 = 1
 *      for i <- 0 to (len + 1) do
 *          sum1 <- sum1 + coins[i]
 *      for i <- (len + 1) to (2*len)+1 do
 *          sum2 <- sum2 + coins[i]
 *      for i <- (2*len) + 1 to numCoins do
 *          sum3 <- sum3 + coins[i]
 *      
 *      if (sum1 % 5 not 0) findFake(first substack)
 *      else if (sum2 % 5 not 0) findFake(second substack)
 *      else if (sum3 % 5 not 0) findFake(thrid Substack)
 * 
 *  if numCoins % 3 = 2
 *      for i <- 0 to (len + 1) do
 *          sum1 <- sum1 + coins[i]
 *      for i <- (len + 1) to 2*(len+1) do
 *          sum2 <- sum2 + coins[i]
 *      for i <- 2*(len+1) to numCoins do
 *          sum3 <- sum3 + coins[i]
 * 
 *      if (sum1 % 5 not 0) findFake(first substack)
 *      else if (sum2 % 5 not 0) findFake(second substack)
 *      else if (sum3 % 5 not 0) findFake(thrid Substack)
 * 
 *  if numCoins % 3 = 0
 *      for i <- 0 to len do
 *          sum1 <- sum1 + coins[i]
 *      for i <- len to (2*len) do
 *          sum2 <- sum2 + coins[i]
 *      for i <- (2*len) to numCoins do
 *          sum3 <- sum3 + coins[i]       
 * 
 *      if (sum1 % 5 not 0) findFake(first substack)
 *      else if (sum2 % 5 not 0) findFake(second substack)
 *      else if (sum3 % 5 not 0) findFake(thrid Substack)
 * 
 * 
 * Question B)
 *  
 */

//Code Section

//Remove if gives error, package assignment was required by my ide
package Assignment3;

//Import for Scanner and ArrayList
import java.util.*;

public class FakeCoin2 {
    //Initialize global variables
    static int divCount = 0;
    public static void main(String[] args) {
        //Initalize Scanner
        Scanner input = new Scanner(System.in);

        //Initalize variables
        boolean run = true;
        int userInput = 0, numCoins = 0;
        ArrayList<Integer> coins = new ArrayList<Integer>(); //Holds weight of coins
        ArrayList<Integer> indices = new ArrayList<Integer>(); //Holds indices to keep track of where coins originally were

        //Sentinel Loop
        while(run){
            Menu(); //Print Menu
            userInput = input(input); //Get menu Input
            switch(userInput){
                case 1: //First Option
                    System.out.print("How many coins are there? ");
                    numCoins = input(input); //Get Number of coins
                    break;
                case 2: //Second Option 
                    coins = getWeights(coins, numCoins, input); //Get coin Weights
                    for (int i = 0; i < numCoins; i++){ //add values to indices list
                        indices.add(i);
                    }
                    break;
                case 3: //Third Option 
                    System.out.println("Finding Fake Coin...\n");
                    System.out.print("Array Size:   " + numCoins + "\n"
                                   + "Array Values: ");
                    for(int i = 0; i < numCoins; i++){
                        System.out.print(coins.get(i) + " ");
                    }
                    System.out.println("");
                    findFake(coins, numCoins, indices); //Find Fake coins
                    break;
                case 4: //Fourth Option
                    System.out.println("Exiting Program...");
                    run = false; //set run to false to break sentinel loop
                    break;
                default: //Default
                    System.out.println("Please input a valid Menu option (1-4)");
                    break;
            }
        }
        input.close();
    }

    /*Print out Main Menu
     * Input: None
     * Output: Main Menu printed in console
     */
    static void Menu(){
        System.out.print("\n-----------------MAIN MENU---------------------------\n"
                        + "1. Read number of coins (array size)\n"
                        + "2. Read array values (all values are 5 except one value 2)\n"
                        + "3. Run algorithm and display results\n"
                        + "4. Exit program\n\n"
                        + "Enter option number: ");
    }

    /*Take user input and make sure it's an integer
     * Input: scanner
     * Output: integer to be used for input
     */
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
    
    /*Get the weights of the Coins. Checks to see if value is valid and prevents duplicate fake coin
     * Input: Arraylist of coins, number of coins, and scanner object
     * Output: Arraylist containing the weights of the coins
     */
    static ArrayList<Integer> getWeights(ArrayList<Integer> coins, int numCoins, Scanner input){
        int weight = 0; //Variable to store weight while checking the value
        coins.removeAll(coins);
        for (int i = 0; i < numCoins; i++){
            while (true){
                System.out.print("What is the weight of the coins in stack " + (i + 1) + " in grams? ");
                weight = input(input); //Take input weight
                if (weight == 2 && !coins.contains(2)){ //If input is 2, check if it's already in the ArrayList
                    coins.add(weight); //Add to ArrayList
                    break;
                } else if(weight == 5) { //Add to list if value is 5
                    coins.add(weight); 
                    break;
                } else if (weight == 2 && coins.contains(2)){ //If value is 2 and 2 is already in list, tell user only one can be in list
                    System.out.println("Only one stack can weigh 2 grams");
                } else { //If value is not 5 or 2, Tell user weights can only be 5 or 2
                    System.out.println("Please input either 5 or 2 grams");
                }
            }
        }
        return coins;
    }

    /*Finds Fake Coin. Gets total weight of 3 parts of the list, then finds the one with the wrong weight. Recursively calls on stack with fake coin
     * Input: ArrayLists containing Coin weights and original Indices, number of coins
     * Output: Prints a string that details the number of divisions and where the fake coin is
     */
    static void findFake(List<Integer> coins, int numCoins, List<Integer> indices){
        //Initialize Variables
        int sum1 = 0, sum2 = 0, sum3 = 0, subLength = (numCoins / 3);

        //Base Case for recursion. If the stack is size 1, or the first element in the stack is not 5
        if (coins.size() == 1 || coins.get(0) < 5){
            System.out.print("# of Divisions:   " + divCount + "\n"
                           + "Fake Coin Index:  " + indices.get(0));
            return;
        }

        //Main Algorithm
        if((numCoins % 3) == 1) { //Case for if there is one extra coin
            divCount++; //Increment division counter 
            for (int i = 0; i < subLength+1; i++){ //Get weight of first substack
                sum1 += coins.get(i);
            }
            for (int i = subLength+1; i < (2*subLength)+1; i++){ //Get weight of second substack
                sum2 += coins.get(i);
            }
            for (int i = (2*subLength)+1; i < numCoins; i++){ //Get weight of third substack
                sum3 += coins.get(i);
            }
            

            if (sum1 % 5 != 0){ //If first substack contains fake coin
                //Recursive call on first portion of the list. First portion is found by starting at the 0 index and going to the 
                // index at subLength+1. List.subList function is inclusive for fromIndex and exclusive for toIndex
                findFake(coins.subList(0, subLength+1), subLength+1, indices.subList(0, subLength+1)); 
            } else if (sum2 % 5 != 0){ //If second substack contains fake coin
                //Recursive call on second portion of the list. Second portion is found by starting at the subLength+1 index and going to the 
                // index at (2*subLenth)+1
                findFake(coins.subList(subLength+1, (2*subLength)+1), subLength, indices.subList(subLength+1, (2*subLength)+1));
            } else if (sum3 % 5 != 0){ //If third substack contains fake coin
                //Recursive call on third portion of the list. Third portion is found by starting at the (2*subLenth)+1 index and going to the 
                // index at numCoins
                findFake(coins.subList((2*subLength)+1, numCoins), subLength, indices.subList((2*subLength)+1, indices.size()));
            }
        } else if((numCoins % 3) == 2) { //Case for if there are 2 extra coins
            divCount++; //increment division counter
            for (int i = 0; i < subLength+1 ; i++){ //Get weight of first substack
                sum1 += coins.get(i);
            }
            for (int i = subLength+1; i < (2*(subLength+1)); i++){ //Get weight of second substack
                sum2 += coins.get(i);
            }
            for (int i = 2*(subLength+1); i < numCoins; i++){ //Get weight of third substack
                sum3 += coins.get(i);
            }
            

            if (sum1 % 5 != 0){ //If first substack contains fake coin
                //Recursive call on first portion of the list. First portion is found by starting at the 0 index and going to the 
                // index at subLength+1. List.subList function is inclusive for fromIndex and exclusive for toIndex
                findFake(coins.subList(0, subLength+1), subLength+1, indices.subList(0, subLength+1));
            } else if (sum2 % 5 != 0){ //If second substack contains fake coin
                //Recursive call on second portion of the list. Second portion is found by starting at the subLength+1 index and going to the 
                // index at 2*(subLenth+1)
                findFake(coins.subList(subLength+1, 2*(subLength+1)), subLength+1, indices.subList(subLength+1, 2*(subLength+1)));
            } else if (sum3 % 5 != 0){ //If third substack contains fake coin
                //Recursive call on third portion of the list. Third portion is found by starting at the 2*(subLenth+1) index and going to the 
                // index at numCoins
                findFake(coins.subList(2*(subLength+1), numCoins), subLength, indices.subList(2*(subLength+1), indices.size()));
            }
        } else {
            
            divCount++; //Increment Division counter
            for (int i = 0; i < subLength; i++){ //Get weight of first substack
                sum1 += coins.get(i);
            }
            for (int i = subLength; i < (2*subLength); i++){ //Get weight of second substack
                sum2 += coins.get(i);
            }
            for (int i = (2*subLength); i < numCoins; i++){ //Get weight of third substack
                sum3 += coins.get(i);
            }
            

            if (sum1 % 5 != 0){ //If first substack contains fake coin
                //Recursive call on first portion of the list. First portion is found by starting at the 0 index and going to the 
                // index at subLength. List.subList function is inclusive for fromIndex and exclusive for toIndex
                findFake(coins.subList(0, subLength), subLength, indices.subList(0, subLength));
            } else if (sum2 % 5 != 0){ //If second substack contains fake coin
                //Recursive call on second portion of the list. Second portion is found by starting at the subLenth index and going to the 
                // index at (2*subLenth)
                findFake(coins.subList(subLength, (2*subLength)), subLength, indices.subList(subLength, (2*subLength)));
            } else if (sum3 % 5 != 0){ //If third substack contains fake coin
                //Recursive call on third portion of the list. Third portion is found by starting at the (2*subLenth) index and going to the 
                // index at numCoins
                findFake(coins.subList((2*subLength), numCoins), subLength, indices.subList((2*subLength), indices.size()));
            }
        }
    }
}
