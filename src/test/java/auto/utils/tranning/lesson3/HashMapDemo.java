package auto.utils.tranning.lesson3;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Tạo một HashMap
        Map<String, String> map = new HashMap<>();

        // Thêm phần tử vào HashMap
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C", "Cherry");
        map.put("D", "Date");
        System.out.println("Initial HashMap: " + map);

        // Thêm phần tử với khóa đã tồn tại
        map.put("B", "Blueberry");
        System.out.println("After put(B, Blueberry): " + map);

        // Lấy giá trị dựa trên khóa
        String valueA = map.get("A");
        System.out.println("Value for key 'A': " + valueA);

        // Kiểm tra sự tồn tại của một khóa
        boolean containsKeyC = map.containsKey("C");
        System.out.println("Contains key 'C': " + containsKeyC);

        // Kiểm tra sự tồn tại của một giá trị
        boolean containsValueBanana = map.containsValue("Banana");
        System.out.println("Contains value 'Banana': " + containsValueBanana);

        // Xóa một phần tử dựa trên khóa
        String removedValue = map.remove("D");
        System.out.println("Removed value for key 'D': " + removedValue);
        System.out.println("After remove(D): " + map);

        // Xóa một phần tử dựa trên khóa và giá trị
        boolean removedEntry = map.remove("B", "Blueberry");
        System.out.println("Removed entry (B, Blueberry): " + removedEntry);
        System.out.println("After remove(B, Blueberry): " + map);

        // Thay thế giá trị cho một khóa
        String oldValue = map.replace("C", "Citrus");
        System.out.println("Replaced value for key 'C': " + oldValue);
        System.out.println("After replace(C, Citrus): " + map);

        // Thay thế giá trị có điều kiện
        boolean replacedConditionally = map.replace("A", "Apple", "Apricot");
        System.out.println("Replaced value conditionally for key 'A': " + replacedConditionally);
        System.out.println("After replace(A, Apple, Apricot): " + map);

        // Lấy tất cả các khóa của HashMap
        System.out.println("Keys: " + map.keySet());

        // Lấy tất cả các giá trị của HashMap
        System.out.println("Values: " + map.values());

        // Lấy tất cả các mục (entry) của HashMap
        System.out.println("Entries: " + map.entrySet());

        // Kiểm tra kích thước của HashMap
        int size = map.size();
        System.out.println("Size of the map: " + size);

        // Kiểm tra xem HashMap có rỗng không
        boolean isEmpty = map.isEmpty();
        System.out.println("Is the map empty? " + isEmpty);

        // Duyệt qua các mục (entry) của HashMap
        System.out.println("Iterating over entries:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Xóa tất cả các mục khỏi HashMap
        map.clear();
        System.out.println("After clear: " + map);
    }
}
