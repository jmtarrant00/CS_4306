
public class Quicksort {
    private int low = 0, high = 1;
    private int[] array;
    private int compCount = 0;
    
    public Quicksort(){
    }

    public void setArray(int[] array){
        this.array = array;
        this.high = array.length - 1;

        QS(this.array, this.low, this.high);

    }

    private int partition(int[] array, int low, int high){
        int temp = 0;
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++){
            if (array[j] <= pivot){
                compCount++;
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        temp = array[i+1];
        array[i+1] = high;
        array[high] = temp;

        return (i + 1);
    }

    private void QS(int[] array, int low, int high){
        if (low < high){
            int pivot = partition(array, low, high);

            QS(array, low, pivot - 1);
            QS(array, pivot + 1, high);
        }
    } 

    // getter for quicksort comparison count
    public int getCompCount(){
        return compCount;
    }
}
