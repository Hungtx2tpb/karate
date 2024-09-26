package auto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.json.simple.parser.JSONParser;


import java.io.*;
import java.util.*;


import static org.junit.Assert.assertTrue;


/**
 * author: ps1.cuongnc
 */
public class TestRunner {
    @Test
    public void testParallel() throws FileNotFoundException {
        File file = new File("target/cucumber-html-reports/");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                System.out.println("Deleteing files: " + myFile);
                myFile.delete();
            }
        }


        Results results = Runner
                .path("src/test/java/auto/features")
                .outputCucumberJson(true)
                .parallel(1);
        TestRunner.generateReport(results.getReportDir());


        Map<String, Object> report = new HashMap<>();
        report.put("totalFeatures", Optional.of(results.getFeaturesTotal()));
        report.put("totalScenarios", results.getScenariosTotal());
        report.put("totalScenariosPassed", results.getScenariosPassed());
        report.put("totalScenariosFailed", results.getScenariosFailed());
        report.put("totalFailed", results.getFailCount());
        report.put("totalFeaturesPassed", results.getFeaturesPassed());
        report.put("totalFeaturesFailed", results.getFeaturesFailed());
        report.put("errorMessage", results.getErrorMessages());
        report.put("efficiency", results.getEfficiency());
        report.put("startTime", results.getStartTime());
        report.put("endTime", results.getEndTime());
        report.put("timeTakenMillis", results.getTimeTakenMillis());
        report.put("totalDuration", results.getElapsedTime());
        // System.out.println("The Scenario results" + results.getScenarioCount());


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writeValueAsString(report);
            FileWriter fileWriter = new FileWriter("target/cucumber-html-reports/summary-report.json");
            fileWriter.write(jsonReport);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateReportGrafana();
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);


    }


    private void generateReportGrafana() throws FileNotFoundException {
        System.out.println("The Results Feature");
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        File directory = new File("target/karate-reports");
        File[] featureJson = directory.listFiles();
        try {


            if (directory != null) {
                for (File jsonFile : featureJson) {
                    System.out.println("File is" + featureJson);
                    if (jsonFile.isFile() && jsonFile.getName().endsWith(".json")) {
                        Object obj = jsonParser.parse(new FileReader(jsonFile));
                        jsonArray.put(obj);
                    }
                    FileWriter file = new FileWriter("target/cucumber-html-reports/feature-summary.json");
                    file.write(jsonArray.toString());
                    file.close();
                }
            }
        } catch (IOException | ParseException fe) {
            fe.printStackTrace();
        }
    }

    public static void generateReport(String karateOutputPath) {


        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "automation-api-karate");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}