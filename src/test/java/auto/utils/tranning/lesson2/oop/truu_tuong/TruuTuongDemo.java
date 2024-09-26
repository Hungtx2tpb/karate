package auto.utils.tranning.lesson2.oop.truu_tuong;

abstract class Animal {
    abstract void sound();
    abstract void speed();
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Chic chíc");
    }

    @Override
    void speed() {

    }
}

class Cat extends Animal {
    public void sound() {
        System.out.println("Meo meo");
    }

    @Override
    void speed() {

    }
}

class Test {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.sound();
        myCat.sound();
    }
}
