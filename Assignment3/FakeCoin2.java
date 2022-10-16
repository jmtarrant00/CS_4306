// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  3
// IDE:         Visual Studio Code

/*Algorithm Design Block
 *  
 *  
 *      
 */

//Code Section

package Assignment3;

import java.util.*;

public class FakeCoin2 {
    static int maxWeight = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userInput = 0, numCoins = 0;
        ArrayList<Integer> coins = new ArrayList<Integer>();

        while(run){
            Menu();
            userInput = input(input);
            switch(userInput){
                case 1:
                    System.out.print("How many coins are there? ");
                    numCoins = input(input);
                    break;
                case 2:
                    coins = getVals(coins, numCoins, input);
                    break;
                case 3: 
                    System.out.println("Finding Fake Coin...\n");
                    System.out.print("Array Size: " + numCoins + "\n"
                                     + "Array Values: ");
                    for(int i = 0; i < numCoins; i++){
                        System.out.print(coins.get(i) + " ");
                    }
                    findFake(coins, numCoins);
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default:
                    System.out.println("Please input a valid Menu option (1-4)");
                    break;
            }
        }
        input.close();
    }

    static void Menu(){
        System.out.print("\n-----------------MAIN MENU---------------------------\n"
                        + "1. Read number of coins (array size)\n"
                        + "2. Read array values (all values are 5 except one value 2)\n"
                        + "3. Run algorithm and display results\n"
                        + "4. Exit program\n\n"
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
    
    static ArrayList<Integer> getVals(ArrayList<Integer> coins, int arraySize, Scanner input){
        int weight;
        boolean containsFake = false;
        coins.removeAll(coins);
        for (int i = 0; i < arraySize; i++){
            while(true){
                System.out.print("What is the value at position " + (i+1) + "? ");
                weight = input(input);
                if (weight > maxWeight){
                    maxWeight = weight;
                }
                if (weight < maxWeight && !containsFake){
                    coins.add(weight);
                    containsFake = true;
                    break;
                } else if (weight < maxWeight && containsFake){
                    System.out.println("Only one coin can be a fake");
                } else if (weight == maxWeight) {
                    coins.add(weight);
                    break;
                }
                
            }
        }
        return coins;
    }

    static void findFake(List<Integer> coins, int numCoins){
        int sum1 = 0, sum2 = 0, sum3 = 0, subLength, count = 0;

        if (coins.size() == 1 && coins.get(0) < maxWeight){
            return;
        }

        if((numCoins % 3) == 1) {
            subLength  = (numCoins / 3);
            for (int i = 0; i < (subLength + 1); i++){
                sum1 += coins.get(i);
                count++;
            }
            subLength += count;
            for (int i = count; i < (subLength + count); i++){
                sum2 += coins.get(i);
                count++;
            }
            subLength += count;
            for (int i = count; i < (subLength + count); i++){
                sum3 = coins.get(i);
            }

            subLength = (numCoins / 3);
            if (sum1 < sum2 && sum1 < sum3){
                subLength++;
                findFake(coins.subList(0, subLength), subLength);
            } else if (sum2 < sum1 && sum2 < sum3){
                findFake(coins.subList(subLength+2, (2*subLength) + 1), subLength);
            } else if (sum3 < sum1 && sum3 < sum1){
                findFake(coins.subList(2*(subLength+1), coins.size()), subLength);
            }
        } else if((numCoins % 3) == 2) {
            subLength  = (numCoins / 3);
            for (int i = 0; i < (subLength + 1); i++){
                sum1 += coins.get(i);
                count++;
            }
            subLength += count;
            for (int i = count; i < (subLength + count + 1); i++){
                sum2 += coins.get(i);
                count++;
            }
            subLength += count;
            for (int i = count; i < (subLength + count); i++){
                sum3 = coins.get(i);
            }

            subLength = (numCoins / 3);
            if (sum1 < sum2 && sum1 < sum3){
                subLength++;
                findFake(coins.subList(0, subLength), subLength);
            } else if (sum2 < sum1 && sum2 < sum3){
                findFake(coins.subList(subLength+2, 2*(subLength+1)), subLength + 1);
            } else if (sum3 < sum1 && sum3 < sum1){
                findFake(coins.subList((2*subLength) + 3, coins.size()), subLength);
            }
        } else {
            subLength  = (numCoins / 3);
            for (int i = 0; i < (subLength); i++){
                sum1 += coins.get(i);
                count++;
            }
            subLength += count;
            for (int i = count; i < (subLength + count); i++){
                sum2 += coins.get(i);
                count++;
            }
            subLength += count;
            for (int i = count; i < (subLength + count); i++){
                sum3 = coins.get(i);
            }

            subLength = (numCoins / 3);
            if (sum1 < sum2 && sum1 < sum3){
                findFake(coins.subList(0, subLength), subLength);
            } else if (sum2 < sum1 && sum2 < sum3){
                findFake(coins.subList(subLength+1, 2*subLength), subLength);
            } else if (sum3 < sum1 && sum3 < sum1){
                findFake(coins.subList((2*subLength)+1, coins.size()), subLength);
            }
        }
       
        
    }
}
