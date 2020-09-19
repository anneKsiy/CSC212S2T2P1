import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Created by 3935415 Abdullah Adam on 2020/09/19
    * TDD (Test Driven Development)
    * Class used to test mergeSort and quickSort
 */
public class SortTestDriver {
    public static void main(String[] args) throws IOException {
//        int n = 5;
//        int arr[] = { 4, 2, 6, 9, 2 };
//        System.out.println("Array at start is: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//
//        SortingUtilities.quickSort(arr, 0, n - 1);
//        System.out.println("\nArray after quickSort is: ");
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//
//        int arr2[] = { 12, 11, 13, 5, 6, 7 };
//        System.out.println("\nArray2 at start is: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr2[i] + " ");
//        }
//
//        SortingUtilities.mergeSort(arr2);
//        System.out.println("\nArray2 after mergeSort is: ");
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr2[i] + " ");
//        }

        List<School> schools = CSVParser.csvToArray("SowetoShort.csv");
//        for (School s : schools) {
//            System.out.println(s);
//        }
//        System.out.println("1");
        List<School> newSchoolArr = new ArrayList<>();
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
//        for (School s : newSchoolArr) {
//            System.out.println(s);
//        }
//        System.out.println("2");
        long startTimeMergeSort = System.nanoTime();
        SortingUtilities.mergeSortSchool(schools);
        long endTimeMergeSort = System.nanoTime();
        long durationMergeSort = (endTimeMergeSort - startTimeMergeSort) / 1000000;
        for (int i = 1, j = 0; i < schools.size(); i++, j++) {
            schools.set(i, newSchoolArr.get(j));
        }


        schools = CSVParser.csvToArray("SowetoShort.csv");
        newSchoolArr = new ArrayList<>();
        for (int i = 1; i < schools.size(); i++) {
            newSchoolArr.add(schools.get(i));
        }
        long startTimeQuickSort = System.nanoTime();
        SortingUtilities.quickSortSchool(newSchoolArr, 0, newSchoolArr.size() - 1);
        long endTimeQuickSort = System.nanoTime();
        long durationQuickSort = (endTimeQuickSort - startTimeQuickSort) / 1000000;

        for (int i = 1, j = 0; i < schools.size(); i++, j++) {
            schools.set(i, newSchoolArr.get(j));
        }
//        for (School s : schools) {
//            System.out.println(s);
//        }
        CSVParser.generateCSV("test.csv", newSchoolArr, durationMergeSort, durationQuickSort);

//        School.sortSchools(schools);
    }
}
