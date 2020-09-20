import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* Created by 3935415 Abdullah Adam on 2020/09/19
 * www.github.com/anneKsiy
 * SortingUtilities class containing the methods:
 * mergeSortSchool(List<School> arr) -> void
 * partitionSchool(List<School> arr, int low, int high) -> int
 * quickSortSchool(List<School> arr, int low, int high) -> void
 * mergeSort(int[] arr) -> void
 * partition(int[] arr, int low, int high) -> int
 * quickSort(int[] arr, int low, int high) -> void
 * arrSwap(int[] arr, int x, int y) -> void
 */
public class SortingUtilities {
    public static void mergeSortSchool(List<School> arr) {
        if (arr == null) return;

        if (arr.size() > 1) {
            int mid = arr.size() / 2;
            /* Split array into a left partition, since ArrayLists are used,
            to avoid a NullPointerException error being thrown, Collections.nCopies
            must be used to place null in each of the indices in the ArrayList
            */
            List<School> left = new ArrayList<>(Collections.nCopies(mid, null));
            for (int i = 0; i < mid; i++) {
                left.set(i, arr.get(i));
            }
            int rightInitialSize = arr.size() - mid;
            /* Split array into a right partition, since ArrayLists are used,
            to avoid a NullPointerException error being thrown, Collections.nCopies
            must be used to place null in each of the indices in the ArrayList
            */
            List<School> right = new ArrayList<>(Collections.nCopies(rightInitialSize, null));
            // iterate from the middle of the array until the length of the array
            for (int i = mid; i < arr.size(); i++) {
                right.set(i - mid, arr.get(i));
            }
            mergeSortSchool(left);
            mergeSortSchool(right);

            int i = 0, j = 0, k = 0;

            // merging the left and right subarrays
            while (i < left.size() && j < right.size()) {
                if (left.get(i).getName().compareTo(right.get(j).getName()) < 0) {
                    arr.set(k, left.get(i));
                    i++;
                } else {
                    arr.set(k, right.get(j));
                    j++;
                }
                k++;
            }
            // the leftover elems will be collected by the following two while loops
            while (i < left.size()) {
                arr.set(k, left.get(i));
                i++;
                k++;
            }
            while (j < right.size()) {
                arr.set(k,right.get(j));
                j++;
                k++;
            }
        }
    }

    public static int partitionSchool(List<School> arr, int low, int high) {
        School pivot = arr.get(high);
        int i = (low - 1); // getting the index of the smaller element
        for (int j = low; j <= high - 1; j++) {
            /* if the current elem is smaller or equal to pivot, we swap
            arr[i] and arr[j]
             */
            if (arr.get(j).getName().compareTo(pivot.getName()) < 0 || arr.get(j).getName() == pivot.getName()) {
                i++;
                School temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        // swap arr[i + 1] and arr[high] (which may be the pivot)
        School temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1; // returns the partition index to be used in the quickSortSchool method
    }
    public static void quickSortSchool(List<School> arr, int low, int high) {
        // low must be less than high for quickSortSchool to run, ie, must have valid arguments
        if (low < high) {
            int partitionIndex = partitionSchool(arr, low, high);
            quickSortSchool(arr, low, partitionIndex - 1);
            quickSortSchool(arr, partitionIndex + 1, high);
        }
    }

    // Implementation of the same algorithms, to be used on integer arrays (int[] arr)
    public static void mergeSort(int[] arr) {
        if (arr == null) return;
        int len = arr.length;
        if (len > 1) {
            int mid = len / 2;

            // Split array into a left partition
            int[] left = new int[mid]; // create the left subarray which is half the size of the array arr
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i]; // place the corresponding values of arr into the left subarray
            }
            // Split array into a right partition
            int[] right = new int[len - mid]; // create the right subarray which is the remaining half of the array
            for (int i = mid; i < len; i++) {
                // iterate from the middle of the array until the length of the array
                right[i - mid] = arr[i]; // the values placed into the right subarray will correspond to the values from arr from mid until len
            }
            mergeSort(left); // recursively call mergeSort on the left subarray
            mergeSort(right); // recursively call mergeSort on the right subarray

            int i = 0, j = 0, k = 0;

            // merge the left and right subarrays
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            // the leftover elems will be collected by the following two while loops
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // gets the index of the smaller elem
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                // if the current elem is smaller or equal to the pivot
                i++;
                arrSwap(arr, i, j); // swap arr[i] and arr[j]
            }
        }
        arrSwap(arr, i + 1, high); // swap arr[i + 1] and arr[high] (which may be the pivot)
        return i + 1; // returns the partition index to be used in the quickSort method
    }
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // low has to be less than high otherwise the method will not run
            int partitionIndex = partition(arr, low, high);
            // recursively call quickSort on the elements before the partition index and after the partition index
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Utility method to abide to *DRY* in partition
    static void arrSwap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
