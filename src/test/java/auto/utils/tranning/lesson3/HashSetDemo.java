package auto.utils.tranning.lesson3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        // Tạo một HashSet
        Set<String> set = new HashSet<>();

        // Thêm phần tử vào HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        System.out.println("After add: " + set);

        // Thêm tất cả các phần tử từ một Collection khác
        Set<String> anotherSet = new HashSet<>();
        anotherSet.add("Grapes");
        anotherSet.add("Mango");
        set.addAll(anotherSet);
        System.out.println("After addAll: " + set);

        // Kiểm tra sự tồn tại của một phần tử
        boolean containsApple = set.contains("Apple");
        System.out.println("Contains 'Apple': " + containsApple);

        // Kiểm tra sự tồn tại của tất cả các phần tử trong một Collection
        Set<String> checkSet = new HashSet<>();
        checkSet.add("Apple");
        checkSet.add("Grapes");
        boolean containsAll = set.containsAll(checkSet);
        System.out.println("Contains all elements of checkSet: " + containsAll);

        // Xóa một phần tử
        set.remove("Banana");
        System.out.println("After remove 'Banana': " + set);

        // Xóa tất cả các phần tử của một Collection
        set.removeAll(anotherSet);
        System.out.println("After removeAll anotherSet: " + set);

        // Kích thước của HashSet
        int size = set.size();
        System.out.println("Size of the set: " + size);

        // Kiểm tra xem HashSet có rỗng không
        boolean isEmpty = set.isEmpty();
        System.out.println("Is the set empty? " + isEmpty);

        // Chuyển HashSet thành một mảng
        Object[] array = set.toArray();
        System.out.println("Array: ");
        for (Object obj : array) {
            System.out.println(obj);
        }

        // Chuyển HashSet thành một mảng có kiểu cụ thể
        String[] stringArray = set.toArray(new String[0]);
        System.out.println("String Array: ");
        for (String str : stringArray) {
            System.out.println(str);
        }

        // Duyệt qua các phần tử của HashSet sử dụng Iterator
        System.out.println("Iterating using Iterator: ");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Xóa tất cả các phần tử khỏi HashSet
        set.clear();
        System.out.println("After clear: " + set);

        // Giữ lại các phần tử cũng có trong một Collection
        Set<String> retainSet = new HashSet<>();
        retainSet.add("Apple");
        retainSet.add("Orange");
        set.retainAll(retainSet);
        System.out.println("After retainAll retainSet: " + set);

    }
}
