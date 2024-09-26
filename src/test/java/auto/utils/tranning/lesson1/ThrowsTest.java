package auto.utils.tranning.lesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsTest {

    public static void main(String[] args) {
        try {
            readFile("nonexistentfile.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader fileInput = new BufferedReader(file);
        throw new IOException("File not found.");
    }
    // An error occurred: nonexistentfile.txt (The system cannot find the file specified)
}
