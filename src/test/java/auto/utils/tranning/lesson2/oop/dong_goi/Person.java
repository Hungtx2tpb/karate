package auto.utils.tranning.lesson2.oop.dong_goi;

public class Person {
    private final String name;  // Thuộc tính name là private
    private int age;      // Thuộc tính age là private

    // Phương thức khởi tạo
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Phương thức công khai để lấy tên
    public String getName() {
        return name;
    }

    // Phương thức công khai để lấy tuổi
    public int getAge() {
        return age;
    }

    // Phương thức công khai để thay đổi tuổi
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Person person = new Person("John", 30);
        String name = person.getName();
        int age = person.getAge();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

    }
}
