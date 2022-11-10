// import java.util.Arrays;
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

        int[][] arrays = {randArray1, randArray2, randArray3, randArray4, 
            incArray1, incArray2, incArray3, incArray4, 
            decArray1, decArray2, decArray3, decArray4};

        Quicksort randQS1 = new Quicksort(), randQS2 = new Quicksort(), randQS3 = new Quicksort(), randQS4 = new Quicksort();
        Mergesort randMS1 = new Mergesort(), randMS2 = new Mergesort(), randMS3 = new Mergesort(), randMS4 = new Mergesort();
        Heapsort randHS1 = new Heapsort(), randHS2 = new Heapsort(), randHS3 = new Heapsort(), randHS4 = new Heapsort();

        Quicksort incQS1 = new Quicksort(), incQS2 = new Quicksort(), incQS3 = new Quicksort(), incQS4 = new Quicksort();
        Mergesort incMS1 = new Mergesort(), incMS2 = new Mergesort(), incMS3 = new Mergesort(), incMS4 = new Mergesort();
        Heapsort incHS1 = new Heapsort(), incHS2 = new Heapsort(), incHS3 = new Heapsort(), incHS4 = new Heapsort();

        Quicksort decQS1 = new Quicksort(), decQS2 = new Quicksort(), decQS3 = new Quicksort(), decQS4 = new Quicksort();
        Mergesort decMS1 = new Mergesort(), decMS2 = new Mergesort(), decMS3 = new Mergesort(), decMS4 = new Mergesort();
        Heapsort decHS1 = new Heapsort(), decHS2 = new Heapsort(), decHS3 = new Heapsort(), decHS4 = new Heapsort();


        while (run){
            Menu();
            question = "Enter Option Number: ";
            userInput = input(input, question);

            switch(userInput){
                case 1:
                    System.out.println("Populating Arrays...");

                    for (int i = 0; i < arrays.length; i++){
                        if (i >= 0 && i < 4){
                            RandomIntegers(arrays[i]);
                        } else if ( i >= 4 && i < 8) {
                            IncreasingIntegers(arrays[i]);
                        } else if (i >= 8 && i < 12){
                            DecreasingIntegers(arrays[i]);
                        }
                    }
                    break;
                case 2:
                    randQS1.setArray(randArray1);
                    randQS2.setArray(randArray2);
                    randQS3.setArray(randArray3);
                    randQS4.setArray(randArray4);
                    incQS1.setArray(incArray1);
                    incQS2.setArray(incArray2);
                    incQS3.setArray(incArray3);
                    incQS4.setArray(incArray4);
                    decQS1.setArray(decArray1);
                    decQS2.setArray(decArray2);
                    decQS3.setArray(decArray3);
                    decQS4.setArray(decArray4);

                    randMS1.setArray(randArray1);
                    randMS2.setArray(randArray2);
                    randMS3.setArray(randArray3);
                    randMS4.setArray(randArray4);
                    incMS1.setArray(incArray1);
                    incMS2.setArray(incArray2);
                    incMS3.setArray(incArray3);
                    incMS4.setArray(incArray4);
                    decMS1.setArray(decArray1);
                    decMS2.setArray(decArray2);
                    decMS3.setArray(decArray3);
                    decMS4.setArray(decArray4);

                    randHS1.setArray(randArray1);
                    randHS2.setArray(randArray2);
                    randHS3.setArray(randArray3);
                    randHS4.setArray(randArray4);
                    incHS1.setArray(incArray1);
                    incHS2.setArray(incArray2);
                    incHS3.setArray(incArray3);
                    incHS4.setArray(incArray4);
                    decHS1.setArray(decArray1);
                    decHS2.setArray(decArray2);
                    decHS3.setArray(decArray3);
                    decHS4.setArray(decArray4);

                    break;
                case 3:
                    System.out.println("Array Type: Random");
                    System.out.println("Algorithm     n=1000     n=10000     n=100000     n=1000000");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("MergeSort     " + randMS1.getCompCount() + "       " + randMS2.getCompCount() + "       " + randMS3.getCompCount() + "       " + randMS4.getCompCount());
                    System.out.println("Quicksort     " + randQS1.getCompCount() + "       " + randQS2.getCompCount() + "       " + randQS3.getCompCount() + "       " + randQS4.getCompCount());
                    
                                     
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
