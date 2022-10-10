// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  2
// IDE:         Visual Studio Code

/*Algorithm Design Block
 * Logical Steps:
 *  Find All subsets of given set
 *      Find sum for all subsets
 *  Search through subsets to find a pair that have the same sum
 * 
 * Algorithm Pseudocode Syntax:
 *  
 *      
 */

//Code Section

//Imports
import java.util.*;

public class Partition {
    public static void main(String[] args) {
        //Variable Declarations
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int userInput = 0;
        int setSize = 0;
        ArrayList<Integer> set = new ArrayList<Integer>();

        //Program Loop
        while (run) {
            Menu();
            userInput = input(input);
            switch(userInput){
                case 1:
                    System.out.print("What is the size of the set? ");
                    setSize = input(input);
                    break;
                case 2:
                    System.out.println("Please input the values in the set\n"
                                     + "----------------------------------");
                    set = fillSet(setSize, input);
                    break;
                case 3:
                    System.out.println("\nFinding Disjoint subsets with same sum...\n");
                    findSubsets(set, setSize);
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default:
                    // System.out.print(Set<Integer> = );
                    System.out.println("Please input a valid menu option.");
                    break;
            }
        }
        
    }

    public static int input(Scanner input){
        // int userInput = 0;
        while(!input.hasNextInt()) { //Checks if the entered input is an integer
            input.next();
            System.out.println("Please enter an Integer");
            System.out.print("Enter Option Number: "); 
        }
        int userInput = input.nextInt(); //Get int input
        return userInput;
    }

    public static void Menu() { //Print out Main Menu
        System.out.print("\n-----------------MAIN MENU-------------- \n"
                            + "1. Read set size (number of integers) \n"
                            + "2. Read integer values \n"
                            + "3. Run algorithm and display output \n"
                            + "4. Exit Program \n"
                            + "\nEnter Option Number: ");
    }

    public static ArrayList<Integer> fillSet(int setSize, Scanner input){
        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int index = 0; index < setSize; index++){
            System.out.print("What is the number in position " + (index + 1) + "? ");
            set.add(input(input));
        }
        return set;
    }

    public static void findSubsets(ArrayList<Integer> set, int setSize){
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<ArrayList<Integer>>();
        int sum;

        //Find all subsets
        for (int i = 0; i < (1<<setSize); i++){
            ArrayList<Integer> subset = new ArrayList<Integer>();
            sum = 0;
            for (int j = 0; j < setSize; j++){
                if ((i & (1 << j)) > 0){
                    subset.add(set.get(j));
                }
            }
            for (int index = 0; index < subset.size(); index++){
                sum += subset.get(index);
            }
            subset.add(sum); //Set subset sum as the last element in the subset
            subSets.add(subset);
        }

        System.out.println("size - 2: " + (subSets.size() - 2));
        for (int i = 1; i < (subSets.size() - 2); i++){
            ArrayList<Integer> subset1 = new ArrayList<Integer>(subSets.get(i)); //Get first subset to look at
            int sum1 = subset1.get(subset1.size() - 1);
            subset1.remove(subset1.size() - 1);                                  //Remove sum from Subset
            for (int j = i+1; j < (subSets.size()-1); j++){
                ArrayList<Integer> subset2 = new ArrayList<Integer>(subSets.get(j)); //Get Second Subset to look at
                int sum2 = subset2.get(subset2.size() - 1);                            //Retrieve Sum from subset
                System.out.println("Sum 1: " + sum1);                          //Retrieve Sum from subset
                System.out.println("Sum 2: " + sum2);
                subset2.remove(subset2.size() - 1);                                    //Remove Sum from subset

                System.out.println("Subset 1: " + subset1);
                System.out.println("Subset 2: " + subset2);
                ArrayList<Integer> intersectSet = new ArrayList<Integer>(subset1); //Copy subset1 to new list to preserve
                boolean intersect = intersectSet.retainAll(subset2);               //Check for disjointness
                System.out.println("Intersect: " + intersect);

                if (sum1 == sum2 && intersect) { //If the sums are the same and the sets are disjoint
                    System.out.println("intersectSet: " + intersectSet);
                    System.out.println("Intersect: " + intersect);
                    System.out.println("Set Size:                  " + setSize + " Integers\n"
                                        + "Integer Values:            " + set + "\n"
                                        + "Disjoint subsets with the same sum: " + subset1 + "\n"
                                        + "                                    " + subset2);
                    return;
                }
            }
        }
        System.out.println("No disjoint subsets with the same sum\nof their elements found");
        return;
    }
}
