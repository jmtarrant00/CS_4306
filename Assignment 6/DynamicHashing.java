// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  6
// IDE:         Visual Studio Code

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

        while(run){
            Menu();
            question = "Enter Option Number: ";
            userInput = input(input, question);

            switch(userInput){
                case 1:
                    if(!hashTable.isEmpty()){
                        hashTable.clear();
                        words.clear();
                        numWords = 0;
                        token = "";
                        for (int i = 0; i < 26; i++){
                            hashTable.add(new ArrayList<ArrayList<String>>());
                        }
                    }
                    System.out.print("Text to hash: ");
                    userString = stringInput(inputString);
                    userString += ' ';
                    System.out.println("User String:  " + userString);
                    break;
                case 2:
                    for (int i = 0; i < 26; i++){
                        hashTable.add(new ArrayList<ArrayList<String>>());
                    }
                    for (int i = 0; i < userString.length(); i++){
                        if (userString.charAt(i) == ' '){
                            numWords++;
                            token = token.toLowerCase();
                            if(!words.contains(token)){
                                words.add(token);
                            }
                            hashFunction(token, hashTable);
                            token = "";
                            i++;
                        }
                        if (i < userString.length() && Character.isLetter(userString.charAt(i))) {
                            token += userString.charAt(i);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Word List: " + words);
                    System.out.println("Key Word    Word Count");
                    System.out.println("----------------------");
                    for(int i = 0; i < words.size(); i++){
                        token = words.get(i);
                        occurences = countOccurences(hashTable, token);
                        if(words.get(i).length() <= 4){
                            System.out.println(token + "            " + occurences);
                        } else {
                            System.out.println(token + "    " + occurences);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Input: " + userString);
                    System.out.println("Inputs Size: " + numWords);
                    System.out.println("Number of Comparisons: " + compCount);
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    run = false;
                    break;
                default:
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

    static String stringInput(Scanner input){
        String userInput = input.nextLine();
        return userInput;
    }
    
    static void hashFunction(String key, ArrayList<ArrayList<ArrayList<String>>> hashTable){
        int index = (int)(key.charAt(0)) - 97;
        ArrayList<ArrayList<String>> list = hashTable.get(index);
        Integer count;

        if(list.size() == 0){
            list.add(new ArrayList<>());
            list.get(0).add(key);
            list.get(0).add("1");
        } else {
            for(int i = 0; i < list.size(); i++){
                compCount++;
                if(key.equals(list.get(i).get(0))){
                    count = Integer.parseInt(list.get(i).get(1));
                    count++;
                    list.get(i).set(1, count.toString());
                    return;
                }              
            }
            list.add(new ArrayList<>());
            list.get(list.size()-1).add(key);
            list.get(list.size()-1).add("1");
            return;
        }

    }

    static int countOccurences(ArrayList<ArrayList<ArrayList<String>>> hashTable, String token){
        int occurences = 0;
        ArrayList<ArrayList<String>> tempList = new ArrayList<>();
        int index = (int)token.charAt(0) - 97;
        tempList = hashTable.get(index);
        for(int i = 0; i < tempList.size(); i++){
            if(tempList.get(i).get(0).equals(token)){
                occurences = Integer.parseInt(tempList.get(i).get(1));
            }
        }
        return occurences;
    }
}
