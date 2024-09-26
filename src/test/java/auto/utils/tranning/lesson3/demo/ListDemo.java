package auto.utils.tranning.lesson3.demo;

import java.util.ArrayList;
import java.util.List;

// Tính tổng các phần tử trong một danh sách số nguyên
public class ListDemo {
    public static int sum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int total = sum(numbers);
        System.out.println("Sum of numbers: " + total);
    }
}

// Kiểm tra xem một phần tử có tồn tại trong danh sách không
class ListDemo2 {
    public static boolean contains(List<String> list, String element) {
        return list.contains(element);
    }

    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Orange", "Grapes");
        String searchElement = "Orange";
        boolean found = contains(fruits, searchElement);
        System.out.println("Does the list contain '" + searchElement + "'? " + found);
    }
}

// Loại bỏ các phần tử trùng lặp từ một danh sách
class ListDemo3 {
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 2, 3, 5, 6, 1);
        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}

//  Đảo ngược một danh sách
class ListDemo4 {
    public static List<Integer> reverse(List<Integer> numbers) {
        List<Integer> reversed = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            reversed.add(numbers.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> reversedNumbers = reverse(numbers);
        System.out.println("Reversed numbers: " + reversedNumbers);
    }
}