import java.util.Random;
public class SortingComparison {
    public static void main(String[] args) {
        int size = 10000;
        int iterations = 10;
        long bubbleTimeTotal = 0;
        long insertionTimeTotal = 0;

        for (int i = 0; i < iterations; i++) {
            int[] array1 = generateRandomArray(size);
            int[] array2 = array1.clone();

            // Bubble Sort
            long startTime = System.nanoTime();
            bubbleSort(array1);
            long endTime = System.nanoTime();
            bubbleTimeTotal += (endTime - startTime);

            // Insertion Sort
            startTime = System.nanoTime();
            insertionSort(array2);
            endTime = System.nanoTime();
            insertionTimeTotal += (endTime - startTime);
        }

        System.out.println("Bubble Sort average time: " + (bubbleTimeTotal / iterations) + " nanoseconds");
        System.out.println("Insertion Sort average time: " + (insertionTimeTotal / iterations) + " nanoseconds");
    }


    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000); // Số ngẫu nhiên từ 0 - 9999
        }
        return array;
    }

    // Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            // Di chuyển các phần tử lớn hơn key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
