/* Created by 3935415 Abdullah Adam on 2020/09/19
 * www.github.com/anneKsiy
 * Class which parses the CSV File into a 2-dimensional array
 */
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class CSVParser {
    public static List<School> csvToArray(String fileName) {
        List<School> schools = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine(); // read the first line from the CSV file
            while (line != null) {
                String[] attributes = line.split(";"); // use string.split to load a string array with the values from each line of the file (; delimiter)
                School school = School.createSchool(attributes);
                schools.add(school); // add a school into the schools ArrayList
                line = br.readLine(); // read the next line before continuing in the loop
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return schools;
    }

    public static void generateCSV(String fileName, List<School> schools, long durationMS, long durationQS) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        PrintWriter out = new PrintWriter(fw);
        out.print("time in milliseconds: " + durationMS + "\n");
        out.print("Result [");
        for (School s : schools) {
            if (schools.indexOf(s) != 0 && schools.indexOf(s) != schools.size() - 1) {
                out.print(" " + s.getName() + ",");
            }
            else if (schools.indexOf(s) == 0) {
                out.print(s.getName() + ",");
            }
            else if (schools.indexOf(s) == schools.size() - 1) {
                out.print(" " + s.getName());
            }
        }
        out.print("]\n\n");
        out.print("time in milliseconds: " + durationQS + "\n");
        out.print("Result [");
        for (School s : schools) {
            if (schools.indexOf(s) != 0 && schools.indexOf(s) != schools.size() - 1) {
                out.print(" " + s.getName() + ",");
            }
            else if (schools.indexOf(s) == 0) {
                out.print(s.getName() + ",");
            }
            else if (schools.indexOf(s) == schools.size() - 1) {
                out.print(" " + s.getName());
            }
        }
        out.print("]");
        out.flush();
        out.close();
        fw.close();
        System.out.println("\nSuccessfully generated and wrote output to file: " + fileName);
    }
}

