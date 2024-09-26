package auto.utils.tranning.lesson2.bai_tap_demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProductsAbovePrice(double price) {
        for (Product product : products) {
            if (product.getPrice() > price) {
                product.display();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm có giá trên mức giá nhất định");
            System.out.println("3. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng mới
                    Product product = new Product(name, price);
                    manager.addProduct(product);
                    break;
                case 2:
                    System.out.print("Nhập mức giá: ");
                    double thresholdPrice = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng mới
                    manager.displayProductsAbovePrice(thresholdPrice);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
}