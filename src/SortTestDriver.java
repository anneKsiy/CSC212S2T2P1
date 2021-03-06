import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* Created by 3935415 Abdullah Adam on 2020/09/19
 * www.github.com/anneKsiy
 * TDD (Test Driven Development)
 * Class used to test mergeSort and quickSort, as well as the implementation of mergeSort and quickSort on ArrayLists of School objects
 */
public class SortTestDriver {
    public static void main(String[] args) throws IOException {
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

        // Start of testing sorting on ArrayLists of School Objects
        SortingUtilities.mergeSort(arr2);
        System.out.println("\nArray2 after mergeSort is: ");

        List<School> schools = CSVParser.csvToArray("SowetoShort.csv");
        List<School> newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        long startTimeMergeSort = System.nanoTime();
        SortingUtilities.mergeSortSchool(schools);
        long endTimeMergeSort = System.nanoTime();
        long durationMergeSort = (endTimeMergeSort - startTimeMergeSort) / 1000000; // Dividing the duration by 1 000 000 to get ms
        for (int i = 1, j = 0; i < schools.size(); i++, j++) {
            schools.set(i, newSchoolArr.get(j));
        }

        schools = CSVParser.csvToArray("SowetoShort.csv");
        newSchoolArr = new ArrayList<>(); // creating a new ArrayList of School Objects
        // adding the schools from the ArrayList<School> schools to newSchoolArr excluding the headings
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        long startTimeQuickSort = System.nanoTime();
        SortingUtilities.quickSortSchool(newSchoolArr, 0, newSchoolArr.size() - 1);
        long endTimeQuickSort = System.nanoTime();
        long durationQuickSort = (endTimeQuickSort - startTimeQuickSort) / 1000000; // Dividing the duration by 1 000 000 to get ms

        // replacing the original schools ArrayList of School Objects with the ordered newSchoolArr ArrayList of School Objects
        for (int i = 1, j = 0; i < schools.size(); i++, j++) {
            schools.set(i, newSchoolArr.get(j));
        }

        // Tests are written to file called "test.csv"
        CSVParser.generateCSV("test.csv",
                newSchoolArr,
                durationMergeSort,
                durationQuickSort);
    }
}
