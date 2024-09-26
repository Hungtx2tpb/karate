package auto.utils.tranning.lesson2.oop.supper;

class Xe {
    int speed = 50;
}

class XeDap extends Xe2 {
    int speed = 100;

    void display() {
        System.out.println(speed); // speed của lớp cha
    }

    public static void main(String[] args) {
        XeDap b = new XeDap();
        b.display();

    }
    // in ra giá trị là 100
}
