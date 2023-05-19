import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        showStudentStatistics();
        showFilesStatistics();
    }

    private static void showStudentStatistics() {

        String fileName = "F:\\MARWAN FCAI\\4th Year\\8th SEMESTER\\Cloud Computing\\Tasks\\Assignment2\\Database\\Main-DB.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Map<String, Integer> courseCountMap = new HashMap<>();
            int totalStudents = 0;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");

                if (parts.length >= 3) {
                    totalStudents++;

                    String[] courses = parts[2].split(",");
                    for (String course : courses) {
                        courseCountMap.put(course, courseCountMap.getOrDefault(course, 0) + 1);
                    }
                }
            }

            System.out.println("Number of Users: " + totalStudents); // Displays total number of students

            for (Map.Entry<String, Integer> entry : courseCountMap.entrySet()) { // Get courses statistics
                System.out.println("Number of students registered in " + entry.getKey() + " course: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showFilesStatistics() {
        String folderPath = "F:\\MARWAN FCAI\\4th Year\\8th SEMESTER\\Cloud Computing\\Tasks\\Assignment2\\Database\\Batch Files";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        int verifiedCount = 0;
        int batchFiles = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".csv")) {
                    String fileName = file.getName();
                    if (fileName.contains("verified"))
                        verifiedCount++;
                    batchFiles++;
                }
            }
        }
        System.out.println("Number of batch files: " + batchFiles);
        System.out.println("Number of verified CSV files: " + verifiedCount);
    }
}
