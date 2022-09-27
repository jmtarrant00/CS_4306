// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  1
// IDE:         Visual Studio Code

/* Algorithm Design Block
 * English Description:
 *  Step 1) Divide Decimal Number by 2
 *  Step 2) Get Int quotient for next round
 *  Step 3) Get Remainder of Decimal Number 
 *  Step 4) Repeat until quotient is 0
 * 
 * In Pseudocode: 
 * while number != 0 do 
 *     binNum[i] = n % 2
 *     number = number / 2
 */ 

// Implementation Section

import java.util.*;

public class DecimalToBinary {
    static Scanner inputScan = new Scanner(System.in);
    public static void main(String []args) {
        int decNum = 0;
        ArrayList<Integer> binNum = new ArrayList<Integer>();
        int input = 0;
        int divisions = 0;
        boolean run = true;
        while(run) { // sentinel loop for program
            Menu(); // Print menu
            input = Input(); // Take user input for menu
            // System.out.println(input);
            switch(input){
                case 1:
                    System.out.print("Please Input a Decimal Number: ");
                    decNum = Input(); // take input for decimal number
                    break;
                case 2:
                    System.out.print("\nDecmal Value: " + decNum); // print decNum
                    while (decNum != 0){        // Loop until the quotient is 0
                        binNum.add(decNum % 2); // Modulus to get binary digit
                        decNum = decNum / 2;    // Int division to get next decNum to work on 
                        divisions++;            // increment number of divisions
                    }
                    System.out.print("\nOutput Binary Number: ");
                    for (int i = binNum.size() - 1; i >= 0; i--){ // print binNum starting at the front of the list
                        System.out.print(binNum.get(i));
                    }
                    System.out.print("\nDivisions: " + divisions); // print number of divisions
                    break;
                case 3:
                    run = false;
                    break;
            }
        }

    }

    public static void Menu() {
        System.out.print("\n-----------------MAIN MENU-------------- \n"
                            + "1. Read input decimal value \n"
                            + "2. Run algorithm and display output \n"
                            + "3. Exit program \n"
                            + "\nEnter Option Number: ");
    }

    public static int Input(){
        String userInput = inputScan.nextLine();
        return Integer.parseInt(userInput);
    }
}
