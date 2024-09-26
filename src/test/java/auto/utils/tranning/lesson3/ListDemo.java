package auto.utils.tranning.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // Tạo một ArrayList
        List<String> fruits = new ArrayList<>();

        // Thêm các phần tử vào ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // In ra các phần tử của ArrayList
        System.out.println("Fruits: " + fruits);

        // Truy cập một phần tử cụ thể
        String firstFruit = fruits.get(0); // Lấy phần tử đầu tiên (Apple)
        System.out.println("First fruit: " + firstFruit);

        // Sửa một phần tử cụ thể
        fruits.set(1, "Mango"); // Thay thế phần tử thứ hai (Banana) bằng Mango
        System.out.println("After modification: " + fruits);

        // Xóa một phần tử cụ thể
        fruits.remove(2); // Xóa phần tử thứ ba (Orange)
        System.out.println("After removal: " + fruits);

        // Kích thước của ArrayList
        int size = fruits.size();
        System.out.println("Size of the list: " + size);

        // Duyệt qua các phần tử của ArrayList
        System.out.println("Iterating over the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Kiểm tra sự tồn tại của một phần tử
        boolean containsApple = fruits.contains("Apple");
        System.out.println("List contains 'Apple': " + containsApple);

        // Create an array of String type
        String[] arr = {"Dog", "Cat", "Horse"};
        System.out.print("Array: ");
        for(String str: arr) {
            System.out.print(str);
            System.out.print(" ");
        }
        // Tạo ArrayList từ mảng
        ArrayList<String> animals = new ArrayList<>(Arrays.asList(arr));
        System.out.println("\nArrayList: " + animals);
    }
}
