package auto.utils.tranning.lesson2.oop.supper;

class Xe2 {
    int speed = 50;
}

class XeDap2 extends Xe2 {
    int speed = 100;

    void display() {
        System.out.println(super.speed); // speed của lớp cha
    }

    public static void main(String[] args) {
        XeDap2 b = new XeDap2();
        b.display();

    }
    // in ra giá trị là 50
}

