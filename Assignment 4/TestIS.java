// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  4
// IDE:         Visual Studio Code

import java.util.*;

public class TestIS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput;
        boolean run = true;
        int Values[] = new int[1024];

        while(run){
            Menu();
            userInput = input(input);
            switch(userInput){
                case 1:
                    int num;
                    System.out.println("Creating Array...");
                    RandomDistinct(Values);

                    System.out.println("Sorted Array:");
                    
                    for (int i = 0; i < Values.length; i++){
                        num = Values[i];

                        if (num < 10){
                            System.out.print(num + "      ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        } else if (num >= 10 && num < 100){
                            System.out.print(num + "     ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        } else if (num >= 100 && num < 1000){
                            System.out.print(num + "    ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        } else {
                            System.out.print(num + "   ");
                            if (((i + 1) % 30) == 0){
                                System.out.println();
                            }
                        }
                    }
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
                    System.out.println("Please input a valid menu option (1-4)");
                    break;
            }
        }
    }

    static void Menu(){
        System.out.print("\n\n---------------MAIN MENU---------------\n"
                       + "1. Create and display array Values[]\n"
                       + "2. Read output table size\n"
                       + "3. Run algorithm and display outputs\n"
                       + "4. Exit program\n"
                       + "\nEnter option number: ");
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

    static void RandomDistinct(int Values[]){
        for (int i = 0; i < Values.length; i++){
            Values[i] = (int)(Math.random()*9999);

            for (int j = 0; j < i; j++){
                if (Values[i] == Values[j]){
                    i--;
                    break;
                }
            }
        }
        sortArray(Values, 0, (Values.length - 1));
    }

    static void swap(int[] Values, int i, int j){
        int temp = Values[i];
        Values[i] = Values[j];
        Values[j] = temp;
    }

    static int partition(int[] Values, int low, int high){
        int pivot = Values[high];
        int i = (low - 1);

        for (int j = low; j <= high; j++){
            if (Values[j] < pivot){
                i++;
                swap(Values, i, j);
            }
        }

        swap(Values, i + 1, high);
        return (i+1);
    }

    static void sortArray(int Values[], int low, int high){
        if (low < high){
            int pi = partition(Values, low, high);

            sortArray(Values, low, pi - 1);
            sortArray(Values, pi + 1, high);
        }
    }
}
