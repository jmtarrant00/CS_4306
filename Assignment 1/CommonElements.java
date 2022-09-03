// Name:        Jnoathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  1

/* Algorithm Design Block
 * Finds common elements in two user-defined lists
 * Input: Two presorted integer lists of length n and m
 * Output: list of common elements
 * 
 * for i = 0 in n do
 *    for j in m do
 *        if list1[i] == list2[j] do 
 *            commonVal.add(list1[i])
 *        compares++
 */ 

// Implementation Section
import java.util.*; // import all of util for scanner and ArrayList

public class CommonElements {
    static Scanner inputScan = new Scanner(System.in);
    public static void main(String []args) {
        int input = 1;
        int comparions = 0;
        int list1[] = new int[5];       //initialize list 1
        int list2[] = new int[5];       //initialize list 2
        ArrayList<Integer> commonVals = new ArrayList<Integer>();   //initialize list commonVals

        boolean run = true; //initialize boolean for sentinel loop
        while(run) { // sentinel loop for program
            Menu(); // Print menu
            input = Input(); // Take user input for menu
            // System.out.println(input);
            switch(input){
                case 1:
                    System.out.println("Input 5 integer values sorted from smallest to largest.");
                    System.out.println("List 1");
                    for (int i = 0; i < list1.length; i++){ // Take input for list1
                        list1[i] = Input();
                    }
                    System.out.println("List 2");
                    for (int i = 0; i < list2.length; i++){ // Take input for list2
                        list2[i] = Input();
                    }
                    break;
                case 2:
                    for (int i = 0; i < list1.length; i++){ // loop through list1
                        for (int j = 0; j < list2.length; j++) { // loop through list2
                            comparions++;
                            if (list1[i] == list2[j]){ // compare current value of list1 to list2 to see if common value
                                commonVals.add(Integer.valueOf(list1[i]));
                            }
                        }
                    }
                    // below code is for printing lists 
                    System.out.print("\nList 1: ");
                    for (int i = 0; i < list1.length; i++){
                        System.out.print(list1[i] + " ");
                    }
                    System.out.print("\nList 2: ");
                    for (int i = 0; i < list2.length; i++) {
                        System.out.print(list2[i] + " ");
                    }
                    System.out.print("\nCommon values: ");
                    for (int i = 0; i < commonVals.size(); i++){
                        System.out.print(commonVals.get(i) + " ");
                    }
                    System.out.print("\nComparisons: " + comparions);
                    break;
                case 3:
                    run = false;
                    break;
                }
            }
        }

    public static void Menu() {
        System.out.print("\n-----------------MAIN MENU-------------- \n"
                            + "1. Read input lists (integer values) \n"
                            + "2. Run algorithm and display output \n"
                            + "3. Exit program \n"
                            + "\nEnter Option Number: ");
    }

    public static int Input() {
        String userInput = inputScan.nextLine();
        return Integer.parseInt(userInput);
    }

    public static ArrayList<Integer> FindCommon(int list1[], int list2[], ArrayList<Integer> commonVals) {
        
        return commonVals;
    }
}
