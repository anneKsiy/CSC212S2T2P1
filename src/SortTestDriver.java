/* Created by Abdullah Adam on 2020/09/19
    * TDD (Test Driven Development)
    * Class used to test mergeSort and quickSort
 */
public class SortTestDriver {
    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 4, 2, 6, 9, 2 };
        System.out.println("Array at start is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        SortingUtilities.quickSort(arr, 0, n - 1);
        System.out.println("\nArray after quickSort is: ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        int arr2[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("\nArray2 at start is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }

        SortingUtilities.mergeSort(arr2);
        System.out.println("\nArray2 after mergeSort is: ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
