package auto.utils.tranning.lesson2.oop.this_demo;

// ==========================  không dùng từ khoá this ================================
public class HocSinh1 {

    int id;
    String name;

    HocSinh1(int id, String name) {
        id = id;
        name = name;
    }

    void hienThi() {
        System.out.println(id + " " + name);
    }

    public static void main(String args[]) {
        HocSinh1 s1 = new HocSinh1(111, "Viet");
        HocSinh1 s2 = new HocSinh1(222, "Nam");
        s1.hienThi();
        s2.hienThi();
        // response
        // 0 null
        // 0 null
    }
}


//=================================  dùng từ khoá this cho khởi tạo biến constructor  ==========================
class HocSinh2 {

    int id;
    String name;

    HocSinh2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void hienThi() {
        System.out.println(id + " " + name);
    }

    public static void main(String args[]) {
        HocSinh1 s1 = new HocSinh1(111, "Viet");
        HocSinh1 s2 = new HocSinh1(222, "Nam");
        s1.hienThi();
        s2.hienThi();
        // response
        // 111 Viet
        // 222 Nam
    }
}



//=================================  dùng từ khoá this gọi constructor lớp hiện tại ==========================
class HocSinh3 {

    int id;
    String name;

    HocSinh3() {
        System.out.println("gọi constructor mặc định");
    }

    HocSinh3(String name) {
        System.out.println("gọi constructor có 1 tham số name: " + name);
    }

    HocSinh3(int id, String name) {
        this(); // nó được sử dụng để gọi constructor của lớp hiện tại
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String args[]) {
        HocSinh3 e1 = new HocSinh3(111, "Viet");
        HocSinh3 e2 = new HocSinh3(222, "Nam");
        e1.display();
        e2.display();

    }
    // response
    // gọi constructor mặc định
    // gọi constructor mặc định
    // 111 Viet
    // 222 Nam

}