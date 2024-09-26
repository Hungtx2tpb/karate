package auto.utils.tranning.lesson2.oop.ke_thua;

public class Animal {
    public void eat() {
        System.out.println("Động vật đang ăn...");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Chó kêu ...");
    }
}

class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}