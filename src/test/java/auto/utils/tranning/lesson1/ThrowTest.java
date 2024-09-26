package auto.utils.tranning.lesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowTest {

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        } else {
            System.out.println("Age is acceptable.");
        }
    }
    // Age must be 18 or older.
}
