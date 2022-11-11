// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  4
// IDE:         Visual Studio Code

/*Algorithm Design Block
 * 
 * 
 */

 // Import Scanner to take input
import java.util.Scanner;

public class testAdvancedSorting {
    public static void main(String[] args) {
        //Create Scanner Object for inputs
        Scanner input = new Scanner(System.in);

        //Initialize Variables
        boolean run = true;
        String question;
        int userInput = 0;

        //Initialize the arrays
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

        //Put names in an array to make it easier to fill them
        int[][] arrays = {randArray1, randArray2, randArray3, randArray4, 
                          incArray1, incArray2, incArray3, incArray4, 
                          decArray1, decArray2, decArray3, decArray4};

        
        //Declare the objects for sorting
        //Random Array objects
        Quicksort randQS1 = new Quicksort(), randQS2 = new Quicksort(), randQS3 = new Quicksort(), randQS4 = new Quicksort();
        Mergesort randMS1 = new Mergesort(), randMS2 = new Mergesort(), randMS3 = new Mergesort(), randMS4 = new Mergesort();
        Heapsort randHS1 = new Heapsort(), randHS2 = new Heapsort(), randHS3 = new Heapsort(), randHS4 = new Heapsort();

        //Incerasing Array Objects
        Quicksort incQS1 = new Quicksort(), incQS2 = new Quicksort(), incQS3 = new Quicksort(), incQS4 = new Quicksort();
        Mergesort incMS1 = new Mergesort(), incMS2 = new Mergesort(), incMS3 = new Mergesort(), incMS4 = new Mergesort();
        Heapsort incHS1 = new Heapsort(), incHS2 = new Heapsort(), incHS3 = new Heapsort(), incHS4 = new Heapsort();
        
        //Decreasing Array Objects
        Quicksort decQS1 = new Quicksort(), decQS2 = new Quicksort(), decQS3 = new Quicksort(), decQS4 = new Quicksort();
        Mergesort decMS1 = new Mergesort(), decMS2 = new Mergesort(), decMS3 = new Mergesort(), decMS4 = new Mergesort();
        Heapsort decHS1 = new Heapsort(), decHS2 = new Heapsort(), decHS3 = new Heapsort(), decHS4 = new Heapsort();


        //Main program loop
        while (run){
            Menu(); //Print the menu
            question = "Enter Option Number: "; //Store last question asked
            userInput = input(input, question); //Get user input 

            //Switch...Case for menu
            switch(userInput){
                case 1: //First Option
                    System.out.println("Populating Arrays...");

                    //For loop to go through the array containing the names of the
                    // arrays that need to be filled
                    for (int i = 0; i < arrays.length; i++){
                        if (i >= 0 && i < 4){
                            //Fill random arrays
                            RandomIntegers(arrays[i]);
                        } else if ( i >= 4 && i < 8) {
                            //Fill Increasing Arrays
                            IncreasingIntegers(arrays[i]);
                        } else if (i >= 8 && i < 12){
                            //Fill Decreasing Arrays
                            DecreasingIntegers(arrays[i]);
                        }
                    }
                    break;
                case 2: //Second Option
                    //Perform Quicksort on arrays
                    System.out.println("Random QS");
                    randQS1.setArray(randArray1);
                    randQS2.setArray(randArray2);
                    randQS3.setArray(randArray3);
                    randQS4.setArray(randArray4);
                    System.out.println("Inc QS");
                    incQS1.setArray(incArray1);
                    incQS2.setArray(incArray2);
                    incQS3.setArray(incArray3);
                    incQS4.setArray(incArray4);
                    System.out.println("Dec QS");
                    decQS1.setArray(decArray1);
                    decQS2.setArray(decArray2);
                    decQS3.setArray(decArray3);
                    decQS4.setArray(decArray4);

                    //Perform MergeSort on arrays
                    System.out.println("Random MS");
                    randMS1.setArray(randArray1);
                    randMS2.setArray(randArray2);
                    randMS3.setArray(randArray3);
                    randMS4.setArray(randArray4);
                    System.out.println("Inc MS");
                    incMS1.setArray(incArray1);
                    incMS2.setArray(incArray2);
                    incMS3.setArray(incArray3);
                    incMS4.setArray(incArray4);
                    System.out.println("Dec MS");
                    decMS1.setArray(decArray1);
                    decMS2.setArray(decArray2);
                    decMS3.setArray(decArray3);
                    decMS4.setArray(decArray4);

                    //Perform Heapsort on arrays
                    System.out.println("Random HS");
                    randHS1.setArray(randArray1);
                    randHS2.setArray(randArray2);
                    randHS3.setArray(randArray3);
                    randHS4.setArray(randArray4);
                    System.out.println("Random HS");
                    incHS1.setArray(incArray1);
                    incHS2.setArray(incArray2);
                    incHS3.setArray(incArray3);
                    incHS4.setArray(incArray4);
                    System.out.println("Random HS");
                    decHS1.setArray(decArray1);
                    decHS2.setArray(decArray2);
                    decHS3.setArray(decArray3);
                    decHS4.setArray(decArray4);

                    break;
                case 3: //Third Option
                    //Print stats for random Arrays
                    System.out.println("\nArray Type: Random");
                    System.out.println("Algorithm     n=1000     n=10000     n=100000     n=1000000");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("MergeSort     " + randMS1.getCompCount() + "       " + randMS2.getCompCount() + "       " + randMS3.getCompCount() + "       " + randMS4.getCompCount());
                    System.out.println("Quicksort     " + randQS1.getCompCount() + "       " + randQS2.getCompCount() + "       " + randQS3.getCompCount() + "       " + randQS4.getCompCount());
                    System.err.println("Heapsort      " + randHS1.getCompCount() + "       " + randHS2.getCompCount() + "       " + randHS3.getCompCount() + "       " + randHS4.getCompCount());
                    
                    //Print stats for Increasing Arrays
                    System.out.println("\nArray Type: Increaasing");
                    System.out.println("Algorithm     n=1000     n=10000     n=100000     n=1000000");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("MergeSort     " + incMS1.getCompCount() + "       " + incMS2.getCompCount() + "       " + incMS3.getCompCount() + "       " + incMS4.getCompCount());
                    System.out.println("Quicksort     " + incQS1.getCompCount() + "       " + incQS2.getCompCount() + "       " + incQS3.getCompCount() + "       " + incQS4.getCompCount());
                    System.err.println("Heapsort      " + incHS1.getCompCount() + "       " + incHS2.getCompCount() + "       " + incHS3.getCompCount() + "       " + incHS4.getCompCount());
                    
                    //Print stats for Decreasing Arrays
                    System.out.println("\nArray Type: Decreasing");
                    System.out.println("Algorithm     n=1000     n=10000     n=100000     n=1000000");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("MergeSort     " + decMS1.getCompCount() + "       " + decMS2.getCompCount() + "       " + decMS3.getCompCount() + "       " + decMS4.getCompCount());
                    System.out.println("Quicksort     " + decQS1.getCompCount() + "       " + decQS2.getCompCount() + "       " + decQS3.getCompCount() + "       " + decQS4.getCompCount());
                    System.err.println("Heapsort      " + decHS1.getCompCount() + "       " + decHS2.getCompCount() + "       " + decHS3.getCompCount() + "       " + decHS4.getCompCount());
                    break;
                case 4: //Fourth Option
                    System.out.println("Exiting Program...");
                    run = false; //Set run to false to stop the while loop
                    break;
                default: // Default case for if user enters non-valid menu option
                    System.out.println("Please Enter a valid Menu Option (1-4)");
                    break;
            }
        }
        
    }

    /*Method to print the menu for user
     * Input: none
     * Output: Prints the menu in the console
     */
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

    /*Take an array and fill it with random integers
     * Input: empty array of n elements
     * Output: array containing n random elements
     */
    static void RandomIntegers(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random()*array.length); //Get random value between 1 and 1000000
        }
    }

    /*Take an array and fill it with increasing numbers
     * Input: empty array of n elements
     * Output: array containing numbers increasing from 1 to n
     */
    static void IncreasingIntegers(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = i+1;
        }
    }

    /*Take an array and fill it with decreasing numbers 
     * Input: empty array of n elements
     * Output: array containing numbers decreasing from n to 1
    */
    static void DecreasingIntegers(int[] array){
        int i = array.length;
        for (int j = 0; j < array.length; j++){
            array[j] = i;
            i--;
        }

    }
}
