package auto.utils.tranning.lesson1.btvn;

public class Bai1 {
    // Viết chương trình tạo ra 2 biến a và b kiểu số nguyên, thực hiện in ra màn hình : a + b, a – b, a * b , a/b
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int tong = a + b;
        int tru = a - b;
        int nhan = a*b;
        int chia = a/b;
        System.out.println("Tổng 2 số : " + tong);
        System.out.println("Hiệu 2 số : " + tru);
        System.out.println("Nhân 2 số : " + nhan);
        System.out.println("Chia 2 số : " + chia);
    }
}
