// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  4
// IDE:         Visual Studio Code

//Imports for Decimal Format and Scanner
import java.text.DecimalFormat; //Used to keep average divs to 3 decimal points
import java.util.Scanner; //used to take user input

public class TestIS {
    public static void main(String[] args) {
        //Variable Declaration/Initialization
        Scanner input = new Scanner(System.in);
        int userInput;
        boolean run = true;
        int Values[] = new int[1024];
        int tableSize = 1;
        String question; //String used to repeat the input question in the case of a non-int input

        while(run){
            Menu(); //Print Menu
            question = "Enter Option number: ";
            userInput = input(input, question); //Get user input

            switch(userInput){
                case 1: //Option 1
                    int num;
                    System.out.println("Creating Array...");
                    RandomDistinct(Values); //Create Array of values

                    System.out.println("Sorted Array:");
                    for (int i = 0; i < Values.length; i++){ 
                        //Used to print all the values in Values[]
                        num = Values[i];

                        //Used to keep the spacing between the numbers consistent regardless of the number of digits
                        if (num < 10){ //For one (1) digit numbers
                            System.out.print(num + "      ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        } else if (num >= 10 && num < 100){ //For two (2) digit numbers
                            System.out.print(num + "     ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        } else if (num >= 100 && num < 1000){ //for three (3) digit numbers
                            System.out.print(num + "    ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        } else { //For four (4) digit numbers
                            System.out.print(num + "   ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        }
                    }
                    break;
                case 2: //Option 2
                    question = "What is the table size? ";
                    System.out.print(question);
                    tableSize = input(input, question); //Get table size
                    break;
                case 3: //Option 3
                    RunIS(Values, tableSize); //Run the Interpolation Search
                    break;
                case 4: //Option 4
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default: //Default if user inputs an invalid menu number
                    System.out.println("Please input a valid menu option (1-4)");
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
                       + "1. Create and display array Values[]\n"
                       + "2. Read output table size\n"
                       + "3. Run algorithm and display outputs\n"
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

    /*Method to get random values for the table. Ensures that the values are 
     *  distinct by checking the new value against the rest of the values in
     *  the array
     * Input: empty integer array to hold the values to search through
     * Output: Array of 1024 distinct random values
     */
    static void RandomDistinct(int Values[]){
        for (int i = 0; i < Values.length; i++){
            Values[i] = (int)(Math.random()*9999); //Get random value between 1 and 9999

            for (int j = 0; j < i; j++){
                if (Values[i] == Values[j]){
                    i--;
                    break;
                }
            }
        }
        sortArray(Values, 0, (Values.length - 1));
    }

    /*Method to swap the values during sorting
     * Input: array containing integers, 2 integers for the index of values 
     *      to be swapped
     * Output: the two values are swapped in the array
     */
    static void swap(int[] Values, int i, int j){
        int temp = Values[i];
        Values[i] = Values[j];
        Values[j] = temp;
    }

    /*Method to partition the array for quicksort
     * Input: array of integers, low index and high index
     * Output: returns int to use for the next partitioning
    */
    static int partition(int[] Values, int low, int high){
        int pivot = Values[high]; //set the pivot to the highest value 
        int i = (low - 1); //set i to lowest value

        for (int j = low; j <= high; j++){
            if (Values[j] < pivot){ 
                //if Values[j] is less than the pivot, increase i and swap Values[i] and Values[j]
                i++;
                swap(Values, i, j);
            }
        }

        swap(Values, i + 1, high); //Swap values[i+1] and Values[high]
        return (i+1);
    }

    /*main method for Quicksort
     * Input: array of integers containing values to be sorted, index of low and high values
     * Output: Sorted array of values to be searched through
     */
    static void sortArray(int Values[], int low, int high){
        if (low < high){
            int pi = partition(Values, low, high);

            sortArray(Values, low, pi - 1); //Recursive call for partition of smaller elements
            sortArray(Values, pi + 1, high); // Recursive call for partition of greater elements
        }
    }

    /*Method to run Interpolation Search and keep track of the stats
     * Input: int Array of values to search through and the number of values to seach for
     * Output: table containing the stats about the search and the values that were searched for
     */
    static void RunIS(int[] Values, int tableSize){
        //Variable Declaration/Initialization
        int key;
        int divSum = 0;
        double average;
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        //Print the header for the table
        System.out.println("\n  Key\t    Found\tIndex\tDivisions\n" 
                       + "-------------------------------------------");
        for (int i = 0; i < tableSize; i++){ //For loop to do the searches
            key = (int)(Math.random()*9999); //Generates random key 
            InterpolationSearch search = new InterpolationSearch(Values, key); //Creates a new instance for the search
            divSum += search.getDivisons(); //Gets the number of divisions
            System.out.println(search); //Prints the stats about the search
        }
        average = (double)divSum / tableSize; //Calculates the average searches
        //Prints divisions stats
        System.err.println("Divisions Average:    " + numberFormat.format(average) + "\n"
                         + "Difference:           " + String.valueOf(3.322 - (int)average));
    }
}
