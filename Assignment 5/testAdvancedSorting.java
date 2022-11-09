import java.util.Arrays;
import java.util.Scanner;

public class testAdvancedSorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        String question;
        int userInput = 0;

        int[] randArray1 = new int[1000];
        int[] randArray2 = new int[10000];
        int[] randArray3 = new int[100000];
        int[] randArray4 = new int[1000000];
        int[] incArray1 = new int[1000];
        int[] incArray2 = new int[10000];
        int[] incArray3 = new int[100000];
        int[] incArray4 = new int[1000000];
        int[] decArray1 = new int[1000];
        int[] decArray2 = new int[10000];
        int[] decArray3 = new int[100000];
        int[] decArray4 = new int[1000000];

        while (run){
            Menu();
            question = "Enter Option Number: ";
            userInput = input(input, question);

            switch(userInput){
                case 1:
                    System.out.println("Populating Arrays...");
                    RandomIntegers(randArray1);
                    System.out.println(Arrays.toString(randArray1));
                    RandomIntegers(randArray2);
                    RandomIntegers(randArray3);
                    RandomIntegers(randArray4);
                    
                    IncreasingIntegers(incArray1);
                    IncreasingIntegers(incArray2);
                    IncreasingIntegers(incArray3);
                    IncreasingIntegers(incArray4);

                    DecreasingIntegers(decArray1);
                    DecreasingIntegers(decArray2);
                    DecreasingIntegers(decArray3);
                    DecreasingIntegers(decArray4);
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
                    break;
            }
        }
        
    }

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

    static void RandomIntegers(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random()*array.length); //Get random value between 1 and 1000000
        }
    }

    static void IncreasingIntegers(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = i+1;
        }
    }

    static void DecreasingIntegers(int[] array){
        int i = array.length;
        for (int j = 0; j < array.length; j++){
            array[j] = i;
            i--;
        }

    }
}
