package auto.utils.tranning.lesson2.oop.supper;

class Xe3 {
    Xe3() {
        System.out.println("Xe được tạo");
    }
}

class XeDap3 extends Xe3 {
    XeDap3() {
        super();// gọi Constructor của lớp cha
        System.out.println("Xe đạp được tạo");
    }

    public static void main(String[] args) {
        XeDap3 b = new XeDap3();
    }
    // response
    //Xe được tạo
    //Xe đạp được tạo
}
