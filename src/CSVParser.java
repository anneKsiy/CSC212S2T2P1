/* Created by 3935415 Abdullah Adam on 2020/09/19
 * Class which parses the CSV File into a 2-dimensional array
 */

import java.util.*;
import java.io.*;
public class CSVParser {
    public static void csvToArray(String fileName) {
    File file = new File(fileName);

        List<List<String>> lines = new ArrayList<>(); // creates a 2D array of strings
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String line = inputStream.next();
                String[] values = line.split(";");
                lines.add(Arrays.asList(values)); // adds current line to the 2D string array
            }
            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // iterates through and prints the 2D array
//        int lineNumber = 1;
//        for (List<String> line: lines) {
//            int columnNumber = 1;
//            for (String value: line) {
//                System.out.println("Line: " + lineNumber + " Column: " + columnNumber + ": " + value);
//                columnNumber++;
//            }
//            lineNumber++;
//        }
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).size(); j++) {
                System.out.println(lines.get(i).get(j));
            }
        }
    }
}
