package auto.utils.tranning.lesson3.btvn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExercise_2 {
    public static boolean areAllUnique(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int num : list) {
            // Nếu phần tử đã tồn tại trong HashSet, trả về false
            if (!set.add(num)) {
                return false;
            }
        }
        // Nếu tất cả các phần tử là duy nhất, trả về true
        return true;
    }

    public static void main(String[] args) {
        // Ví dụ
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> numbers2 = List.of(1, 2, 3, 3, 4, 5);

        System.out.println("Are all elements in numbers1 unique? " + areAllUnique(numbers1));
        System.out.println("Are all elements in numbers2 unique? " + areAllUnique(numbers2));
    }
}
