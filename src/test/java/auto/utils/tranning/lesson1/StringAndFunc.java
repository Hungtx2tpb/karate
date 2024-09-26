package auto.utils.tranning.lesson1;

import java.util.Arrays;

public class StringAndFunc {
    public static void main(String[] args) {
        String str = "Hello, World!";

        System.out.println("Length: " + str.length()); // Length: 13
        System.out.println("Char at 0: " + str.charAt(0)); // Char at 0: H
        System.out.println("Substring (0-5): " + str.substring(0, 5)); // Substring (0-5): Hello
        System.out.println("Contains 'World': " + str.contains("World")); // Contains 'World': true
        System.out.println("Index of 'World': " + str.indexOf("World")); // Index of 'World': 7
        System.out.println("Last index of 'o': " + str.lastIndexOf("o")); // Last index of 'o': 8
        System.out.println("Uppercase: " + str.toUpperCase()); // Uppercase: HELLO, WORLD!
        System.out.println("Lowercase: " + str.toLowerCase()); // Lowercase: hello, world!
        System.out.println("Trimmed: " + str.trim()); // Trimmed: Hello, World!
        System.out.println("Replace 'o' with 'a': " + str.replace('o', 'a')); // Replace 'o' with 'a': Hella, Warld!
        System.out.println("ReplaceAll 'o' with 'a': " + str.replaceAll("o", "a")); // ReplaceAll 'o' with 'a': Hella, Warld!
        System.out.println("Equals 'Hello, World!': " + str.equals("Hello, World!")); // Equals 'Hello, World!': true
        System.out.println("EqualsIgnoreCase 'hello, world!': " + str.equalsIgnoreCase("hello, world!")); // EqualsIgnoreCase 'hello, world!': true
        System.out.println("StartsWith 'Hello': " + str.startsWith("Hello")); // StartsWith 'Hello': true
        System.out.println("EndsWith 'World!': " + str.endsWith("World!")); // EndsWith 'World!': true
        System.out.println("CompareTo 'Hello, World!': " + str.compareTo("Hello, World!")); // CompareTo 'Hello, World!': 0
        System.out.println("CompareToIgnoreCase 'hello, world!': " + str.compareToIgnoreCase("hello, world!")); // CompareToIgnoreCase 'hello, world!': 0
        System.out.println("Matches '.*World.*': " + str.matches(".*World.*")); // Matches '.*World.*': true
        System.out.println("Split: " + Arrays.toString(str.split(", "))); // Split: [Hello, World!]
    }
}
