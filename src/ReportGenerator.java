import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {

    private static final String CSV_FILE = "hospital.csv";

    private static final String REPORT_DIR = "reports/";

    public static void main(String[] args) throws IOException {

        // Read CSV file and store data in a map
        Map<String, Map<String, Integer>> data = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(CSV_FILE));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            String date = fields[0];
            String department = fields[1];
            int count = Integer.parseInt(fields[2]);
            if (!data.containsKey(date)) {
                data.put(date, new HashMap<>());
            }
            data.get(date).put(department, count);
        }
        br.close();

        // Generate daily reports
        for (String date : data.keySet()) {
            String reportName = REPORT_DIR + date + ".txt";
            FileWriter fw = new FileWriter(reportName);
            fw.write("Daily Report for " + date + "\n\n");
            Map<String, Integer> dailyData = data.get(date);
            for (String department : dailyData.keySet()) {
                int count = dailyData.get(department);
                fw.write(department + ": " + count + "\n");
            }
            fw.close();
        }

        // Generate monthly reports
        Map<String, Map<String, Integer>> monthlyData = new HashMap<>();
        for (String date : data.keySet()) {
            String month = date.substring(0, 7);
            if (!monthlyData.containsKey(month)) {
                monthlyData.put(month, new HashMap<>());
            }
            Map<String, Integer> dailyData = data.get(date);
            for (String department : dailyData.keySet()) {
                int count = dailyData.get(department);
                if (!monthlyData.get(month).containsKey(department)) {
                    monthlyData.get(month).put(department, count);
                } else {
                    monthlyData.get(month).put(department, monthlyData.get(month).get(department) + count);
                }
            }
        }
        for (String month : monthlyData.keySet()) {
            String reportName = REPORT_DIR + month + ".txt";
            FileWriter fw = new FileWriter(reportName);
            fw.write("Monthly Report for " + month + "\n\n");
            Map<String, Integer> monthlyDataForDepartment = monthlyData.get(month);
            for (String department : monthlyDataForDepartment.keySet()) {
                int count = monthlyDataForDepartment.get(department);
                fw.write(department + ": " + count + "\n");
            }
            fw.close();
        }

    }

}

