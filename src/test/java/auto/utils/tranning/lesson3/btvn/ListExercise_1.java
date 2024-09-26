package auto.utils.tranning.lesson3.btvn;

import java.util.List;

public class ListExercise_1 {
    public static int sumOfList(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = sumOfList(numbers);
        System.out.println("Sum of the list: " + sum);
    }
}
