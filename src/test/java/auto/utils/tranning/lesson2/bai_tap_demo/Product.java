package auto.utils.tranning.lesson2.bai_tap_demo;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Phương thức để hiển thị thông tin sản phẩm
    public void display() {
        System.out.println("Tên: " + name);
        System.out.println("Giá: " + price);
    }
}