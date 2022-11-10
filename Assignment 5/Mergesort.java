

public class Mergesort {
    private int right, left = 0, middle;
    private int[] array;
    private int compCount = 0;

    public Mergesort(){

    }

    public void setArray(int[] array){
        this.array = array;
        this.right = array.length - 1;

        MS(this.array, this.left, this.right);
    }

    private void merge(int[] array, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++){
            leftArr[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++){
            rightArr[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2){
            if (leftArr[i] <= rightArr[j]){
                array[k] = leftArr[i];
                i++;
                compCount++;
            } else {
                array[k] = rightArr[j];
                j++;
                compCount++;
            }
            k++;
        }

        while (i < n1){
            array[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2){
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private void MS(int[] array, int left, int right){
        if (left < right){
            middle = left + (right - 1) / 2;

            MS(array, left, middle);
            MS(array, middle+1, right);

            merge(array, left, middle, right);
        }
    }

    public int getCompCount(){
        return compCount;
    }
}
