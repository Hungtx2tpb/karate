package auto.utils.tranning.lesson2.oop.da_hinh;

public class Shape {
    public void draw() {
        System.out.println("Vẽ hình...");
    }

    public void color() {
        System.out.println("màu của hình...");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn...");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình vuông...");
    }
}

class Test {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Square();
        shape1.draw();
        shape2.draw();
    }
}
