// Name:        Jonathan Tarrant
// Class:       CS 4306/2
// Term:        Fall 2022
// Instructor:  Dr. Haddad
// Assignment:  4
// IDE:         Visual Studio Code


public class InterpolationSearch {
    private int key;            //Holds the value of the current key
    private boolean Found;      //indicates if search key is found or not       
    private int Index = -1;     //holds index of target value if found in list else -1
    private int Divisions = 0;  //holds # of divisions
    private int[] searchSpace;
    private int low = 0;
    private int high = 1023;    
    
    //Class constructor. Class needs an array to search through and the key to search for
    public InterpolationSearch(int searchSpace[], int key){
        //clone the array passed into the object to not affect it during the search
        this.searchSpace = searchSpace.clone(); 
        this.key = key; //set this.key to the value passed in

        search(this.searchSpace, this.key, low, high); //Run the search using the variables from the object
    }

    /*Interpolation Search method. The search guesses the position of key then redoes 
     *  the search with a smaller portion of the array. The smaller portion depends on if the 
     *  guessed index held a value larger or smaller than the key
     * Input: sorted array, value to search for, indices of the high and low values
     * Output: Finds the value in the array if it exists
     */
    public void search(int searchSpace[], int key, int low, int high){
        int pos;

        if (low <= high && key >= searchSpace[low] && key <= searchSpace[high]){
            /*Guess the position of the key using information from the array. 
             * Equation used is the equation for a line between two points 
             * solved for x
             */
            pos = low + (int)Math.floor(((key - searchSpace[low])*(high - low))
                                        /(searchSpace[high]-searchSpace[low]));

            if (searchSpace[pos] == key){ //If the key is found
                Index = pos;
                Found = true;
                return;
            }

            if (searchSpace[pos] < key){ //If the guessed position holds a value less than the key
                Divisions++;
                search(searchSpace, key, pos + 1, high);
            }

            if (searchSpace[pos] > key){ //if the guessed position holds a value greater than the key
                Divisions++;
                search(searchSpace, key, low, pos - 1);
                
            }
        }
        return;
    }

    //Getter for the number of divisions
    public int getDivisons(){
        return Divisions;
    }

    //toString method to make printing the stats easier
    public String toString(){ 
        return ("  " + key + "\t     " + Found + "\t " + Index + "\t   " + Divisions);
    }

        
         
}
