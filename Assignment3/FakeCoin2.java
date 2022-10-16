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
                    System.out.println("Finding Fake Coin...");
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
    
    static ArrayList<Integer> getVals(ArrayList<Integer> coins, int arraySize, Scanner input){
        int weight;
        coins.removeAll(coins);
        for (int i = 0; i < arraySize; i++){
            System.out.print("What is the value at position " + (i+1) + "? ");
            weight = input(input);
            coins.add(weight);
            if (weight > maxWeight){
                maxWeight = weight;
            }
        };
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

            if (sum1 < sum2 && sum1 < sum3){
                subLength = (numCoins / 3);
                findFake(coins.subList(0, subLength + 1), subLength + 1);
            } else if (sum2 < sum1 && sum2 < sum3){

            } else if (sum3 < sum1 && sum3 < sum1){

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
        }

    }
}
