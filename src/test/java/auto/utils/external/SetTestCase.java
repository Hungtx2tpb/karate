package auto.utils.external;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetTestCase {
    private static Pattern regex = Pattern.compile("([^\\s]+(\\.(?i)(json))$)");
        private static final String dir = System.getProperty("user.dir");
    private static FileWriter fw;

    public static boolean validateFileMatchRegex(String userName) {
        Matcher mtch = regex.matcher(userName);
        if (mtch.matches()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        try {
            Path path = Paths.get(dir + "/target/xray-config/");
            Files.createDirectories(path);
            System.out.println("Directory is created!");
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

        String folder = dir + "/target/surefire-reports";
        File directoryPath = new File(folder);
        //List of all files and directories
        String contents[] = directoryPath.list();

        File files[] = directoryPath.listFiles();
        for (File file : files) {
            if (validateFileMatchRegex(file.getName())) {
                System.out.println("File name: " + file.getName());
                System.out.println("File getParent: " + file.getParent());
                System.out.println("File path: " + file.getPath());
                try {
                    fw = new FileWriter(dir + "/target/xray-config/" + file.getName());
                    fw.write(file.getName());
                    fw.flush();
                } catch (IOException e) {
                    System.out.println("Writing " + file.getName() + " file failed");
                    e.printStackTrace();
                }
            }
        }
    }
}
