package auto.utils.tranning.lesson2;

import com.redis.S;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhileDemo {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            System.out.println("i = " + i);
            i++;
            if (i > 5) {
                break;
            }
        }
    }

    public void Main() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Nhập vào một số lớn hơn 0 : ");
            number = scanner.nextInt();
        } while (number <= 0);
        System.out.println("Số bạn vừa nhập là: " + number);
        List  s = new ArrayList<>();
        String b = (String) s.set(1, "a");
    }
}
