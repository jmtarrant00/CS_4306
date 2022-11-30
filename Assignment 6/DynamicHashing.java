// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  6
// IDE:         Visual Studio Code

/* Analysis Block
 *  Test 1: 0 Comparisons
 *  Test 2: 25 Comparisons
 *  Test 3: 325 Comparisons
 *  Test 4: 27 Comparisons
 *  Test 5: 1632 Comparisons
 * 
 * For test 1, we got 0 comparisons. This is because there was only one word that started with each letter, 
 *  meaning that there were no comparisons to be made since each word was hashed to a unique spot. This changed
 *  the rest of the tests, with the number of comparisons for the rest of the tests rising. For tests 2 and 3, 
 *  the reason that the values differ so drastically even though they both only contain words that start with 
 *  the same letter is that for test 2, all of the words are the same, so the program only had to make one
 *  comparison for each word. In test 3 however, all of the words are different, meaning that each word had to be
 *  compared to all the other words already in the hash table. The number of comparisons here reflects the theoretical 
 *  numbers from the slides
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicHashing {
    static int compCount;
    public static void main(String[] args) {
        //initialize variables
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        boolean run = true;
        String question = "";
        int userInput = 0;
        String userString = "";
        String token = "";
        int occurences = 0;
        int numWords = 0;


        //create 3d arraylist to for the hash table. 3 dimensions needed for: 1 for storing the full list
        // one for storing the list of words for each hash, and one for storing the word and it's occurences
        ArrayList<ArrayList<ArrayList<String>>> hashTable = new ArrayList<ArrayList<ArrayList<String>>>();

        //Arraylist to hold the individual words for recall
        ArrayList<String> words = new ArrayList<String>();

        //Main program loop
        while(run){
            Menu(); //Print Menu
            question = "Enter Option Number: "; //set question for function
            userInput = input(input, question); //get user input for option

            //Switch statement for menu operation
            switch(userInput){
                case 1: //FIRST OPTION
                    if(!hashTable.isEmpty()){ //reset all the values for the program if option one is selected again
                        hashTable.clear();
                        words.clear();
                        numWords = 0;
                        token = "";
                        compCount = 0;
                    }
                    //Get user input for the string 
                    System.out.print("Text to hash: ");
                    userString = stringInput(inputString);
                    userString += ' '; //Add a space to the end of the string to allow program to parse last word
                    System.out.println("User String:  " + userString);
                    //print string to ensure that it is correct
                    break;
                case 2: //SECOND OPTION
                    //Fill Hast Table with 26 spots
                    for (int i = 0; i < 26; i++){
                        hashTable.add(new ArrayList<ArrayList<String>>());
                    }

                    // Read the user string into the word list and hash table
                    for (int i = 0; i < userString.length(); i++){
                        if (userString.charAt(i) == ' '){
                            numWords++;
                            token = token.toLowerCase(); //convert all letters to lower case
                            if(!words.contains(token)){ //check to see if token is already in word list
                                words.add(token); //add token to word list
                            }
                            //Run the hash function on the token
                            hashFunction(token, hashTable);
                            token = ""; //reset the token
                            i++; //increment i again to skip the space
                        }
                        if (i < userString.length() && Character.isLetter(userString.charAt(i))) {
                            //check whether within the string, and if the current character is a letter
                            token += userString.charAt(i); //add character to token
                        }
                    }
                    break;
                case 3: //THIRD OPTION
                    System.out.println("Word List: " + words);
                    System.out.println("Key Word    Word Count");
                    System.out.println("----------------------");
                    //for each word in word list, retreive the number of occurences
                    for(int i = 0; i < words.size(); i++){
                        token = words.get(i);
                        occurences = countOccurences(hashTable, token); //set the number of occurences to the output of the countOccurences function
                        System.out.format("%-6s %10s\n", token, occurences); //Print out the token and the times it occurs
                    }
                    break;
                case 4: //FOURTH OPTION
                    System.out.println("Input: " + userString);
                    System.out.println("Inputs Size: " + numWords);
                    System.out.println("Number of Comparisons: " + compCount);
                    break;
                case 5: //EXIT OPTION 
                    System.out.println("Exiting Program...");
                    run = false; //set run to false to break the while loop
                    break;
                default: //DEFAULT OPTION
                    System.out.println("Please input a valid menu option (1-5).");
                    break;
            }
        }

        input.close();
        inputString.close();
        
    }   
    
    /*Method to print the menu for user
     * Input: none
     * Output: Prints the menu in the console
     */
    static void Menu(){
        System.out.print("\n\n---------------MAIN MENU---------------\n"
                       + "1. Read Text Input\n"
                       + "2. Hash Input Text to Hash Table\n"
                       + "3. Display Words and Occurences\n"
                       + "4. Display Efficiency Outputs\n" 
                       + "5. Exit Program\n" 
                       + "\nEnter option number: ");
    }

    /*Take user input and make sure it's an integer
     * Input: scanner
     * Output: integer to be used for input
     */
    static int input(Scanner input, String question){
        while(!input.hasNextInt()) { //Checks if the entered input is an integer
            input.next();
            System.out.println("Please enter an Integer\n");
            System.out.print(question); 
        }
        int userInput = input.nextInt(); //Get int input
        return userInput;
    }

    /*This function takes the string input from the user and returns it
     * Input: Scanner object
     * Output: user string 
     */
    static String stringInput(Scanner input){
        String userInput = input.nextLine();
        return userInput;
    }

    /*This is the hash function. It takes the token provided to it, converts the first 
     *  letter of the token to ascii code, then normalizes it to the range of indices for
     *  the hash table. Once it has the normalized input, it checks to see if the hash table
     *  is empty, or if the word is already in the table. If the word is already in the hash table
     *  it increments the counter for that word
     * 
     * Input: token string, and the arraylist containing the hash table
     * Output: the hash table with the key in the proper place
     */    
    static void hashFunction(String key, ArrayList<ArrayList<ArrayList<String>>> hashTable){
        //Initialize Variables

        int index = (int)(key.charAt(0)) - 97; //Get the index for the hash table that the token corresponds to

        ArrayList<ArrayList<String>> list = hashTable.get(index); //grab the list of tokens at the proper index
        Integer count;

        //If the list is empty 
        if(list.size() == 0){
            list.add(new ArrayList<>());
            list.get(0).add(key);
            list.get(0).add("1");
        } else {
            //Scan through the list of tokens and see if the current token matches any that are ther
            for(int i = 0; i < list.size(); i++){
                compCount++; //increment comparison count
                if(key.equals(list.get(i).get(0))){ //check if token is equal to current word
                    //Extract the count and parse it to an int. Increment it, then put it back in the list as a string
                    count = Integer.parseInt(list.get(i).get(1));
                    count++;
                    list.get(i).set(1, count.toString());
                    return; //Return to main
                }              
            }
            //If the word is not in the list
            list.add(new ArrayList<>());
            list.get(list.size()-1).add(key);
            list.get(list.size()-1).add("1");
            return;
        }

    }

    /*This function counts the occurences for each word in the hash table. It creates a 
     *  temporary list of the index for the word, using the same method as the hash function.
     *  It then scans through that list to find the right word, then extracts the occurences 
     *  for that word. 
     * 
     * Input: Hash table and the token to find
     * Output: an int containing the number of occurences of the token
     */
    static int countOccurences(ArrayList<ArrayList<ArrayList<String>>> hashTable, String token){
        //Initialize Variables
        int occurences = 0;
        ArrayList<ArrayList<String>> tempList = new ArrayList<>();
        //Get index for word list 
        int index = (int)token.charAt(0) - 97;
        tempList = hashTable.get(index);
        for(int i = 0; i < tempList.size(); i++){ //Scan through word list for token
            if(tempList.get(i).get(0).equals(token)){
                occurences = Integer.parseInt(tempList.get(i).get(1)); //Extract occurences
            }
        }
        //Return Occurences
        return occurences;
    }
}
