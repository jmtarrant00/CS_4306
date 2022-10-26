// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  4
// IDE:         Visual Studio Code

import java.util.*;

public class InterpolationSearch {
    private boolean Found;  //indicates if search key is found or not       
    private int Index = -1; //holds index of target value if found in list else -1
    private int Divisions = 0;  //holds # of divisions
    private int[] searchSpace;
    private int key;
    private int low;
    private int high;
    private int[] returns = new int[]{-1, -1, -1, -1};
    
    
    public InterpolationSearch(int searchSpace[], int key, int low, int high){
        this.searchSpace = searchSpace;
        this.key = key;
        this.low = low;
        this.high = high;

    }

    public int[] search(int pos){


        if (low <= high && key >= searchSpace[low] && key <= searchSpace[high]){
            pos = low + (((high - low) / 
                          (searchSpace[high] - searchSpace[low])) * key -searchSpace[low]);
            Divisions++;
            Index = pos;

            if (searchSpace[pos] == key){
                Found = true;
                returns[0] = key;
                returns[1] = Found ? 1 : 0;
                returns[2] = Index;
                returns[3] = Divisions;
                return returns;
            }

            if (searchSpace[pos] < key){
                return search(pos+1);
            }
        }

        return returns;
    }

        
         
}
