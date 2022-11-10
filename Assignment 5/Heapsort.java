
public class Heapsort {
    private int[] array;
    private int compCount = 0;

    public Heapsort(){

    }

    public void setArray(int[] array){
        this.array = array;

        HS(this.array);
    }

    private void HS(int[] array){
        int n = array.length;
        int temp;

        for (int i = (n/2-1); i >= 0; i--){
            heapify(array, n, i);
        }

        for (int i = n-1; i > 0; i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int swap;

        if (left < n && array[left] > array[largest]){
            largest = left;
            compCount++;
        }

        if (right < n && array[right] > array[largest]){
            largest = right;
            compCount++;
        }

        if (largest != i){
            compCount++;
            swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }

       
    }

    public int getCompCount(){
        return compCount;
    }
}
