package auto.utils.tranning.lesson3.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Viết một phương thức nhận vào một danh sách và trả về một HashSet chứa các phần tử duy nhất từ danh sách đó.
public class SetDemo {
    public static Set<String> findUniqueElements(List<String> list) {
        return new HashSet<>(list);
    }

    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Orange", "Apple", "Grapes");
        Set<String> uniqueFruits = findUniqueElements(fruits);
        System.out.println("Unique elements: " + uniqueFruits);
    }
}

// Viết một phương thức nhận vào một danh sách và một phần tử cần kiểm tra. Phương thức này sẽ trả về true nếu phần tử tồn tại trong danh sách và false nếu không.
class SetDemo2 {
    public static boolean containsElement(List<String> list, String element) {
        Set<String> set = new HashSet<>(list);
        return set.contains(element);
    }

    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Orange", "Grapes");
        String searchElement = "Orange";
        boolean found = containsElement(fruits, searchElement);
        System.out.println("Does the list contain '" + searchElement + "'? " + found);
    }
}

// Viết một phương thức nhận vào một danh sách và trả về một HashSet chỉ chứa các phần tử không trùng lặp từ danh sách đó.
class SetDemo3 {
    public static Set<Integer> removeDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 2, 3, 5, 6, 1);
        Set<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}

