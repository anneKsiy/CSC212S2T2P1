import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* Created by 3935415 Abdullah Adam on 2020/09/20
 * www.github.com/anneKsiy
 * Once code has passed all tests in "SortTestDriver.java", "Main.java" may be run
 * Class used to complete all tasks listed in the project spec
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<School> schools = CSVParser.csvToArray("Soweto.csv");
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

        schools = CSVParser.csvToArray("Soweto.csv");
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

        CSVParser.generateCSV("Output.txt",
                newSchoolArr,
                durationMergeSort,
                durationQuickSort);
    }
}
