package auto.utils.tranning.lesson3.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // Tạo một đối tượng HashMap để lưu trữ thông tin của sinh viên
        Map<String, Integer> studentScores = new HashMap<>();

        // Thêm thông tin của sinh viên vào HashMap
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 90);
        studentScores.put("Charlie", 75);
        studentScores.put("David", 80);

        // In ra điểm số của mỗi sinh viên
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Lấy điểm số của một sinh viên cụ thể
        String studentName = "Bob";
        int score = studentScores.get(studentName);
        System.out.println(studentName + "'s score: " + score);

        // Kiểm tra xem một sinh viên có tồn tại trong HashMap không
        String searchName = "Alice";
        boolean exists = studentScores.containsKey(searchName);
        System.out.println("Does " + searchName + " exist? " + exists);

        // Xóa thông tin của một sinh viên khỏi HashMap
        String removeName = "Charlie";
        studentScores.remove(removeName);
        System.out.println("After removing " + removeName + ": " + studentScores);
    }
}

class MapDemo2 {
    public static void main(String[] args) {
        String sentence = "This is a simple example sentence to demonstrate word counting in Java.";

        // Tách các từ trong câu và lưu vào một mảng
        String[] words = sentence.split("\\s+");
        System.out.println(Arrays.toString(words));

        // Tạo một HashMap để lưu trữ số lần xuất hiện của từng từ
        Map<String, Integer> wordCounts = new HashMap<>();

        // Đếm số lần xuất hiện của từng từ trong mảng và lưu vào HashMap
        for (String word : words) {
            // Chuyển đổi từ sang chữ thường để loại bỏ sự phân biệt về chữ hoa chữ thường
            String lowercaseWord = word.toLowerCase();
            // Kiểm tra xem từ đã tồn tại trong HashMap chưa
            if (wordCounts.containsKey(lowercaseWord)) {
                // Nếu từ đã tồn tại, tăng giá trị số lần xuất hiện lên 1
                wordCounts.put(lowercaseWord, wordCounts.get(lowercaseWord) + 1);
            } else {
                // Nếu từ chưa tồn tại, thêm vào HashMap với số lần xuất hiện là 1
                wordCounts.put(lowercaseWord, 1);
            }
        }

        // In ra số lần xuất hiện của từng từ
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println("'" + entry.getKey() + "' appears " + entry.getValue() + " times.");
        }
    }
}
