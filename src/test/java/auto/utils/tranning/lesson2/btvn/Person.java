package auto.utils.tranning.lesson2.btvn;

import java.text.DecimalFormat;

public class Person {
    private String name;
    private int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String displayInfo() {
        return " name = " + name + " and age = " + age;
    }
}

class Employee extends Person {
    private String idNv;
    private double salary;

    public Employee(int age, String name, String idNv, double salary) {
        super(age, name);
        this.idNv = idNv;
        this.salary = salary;
    }

    public String getIdNv() {
        return idNv;
    }

    public void setIdNv(String idNv) {
        this.idNv = idNv;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String displayInfo() {
        DecimalFormat decimalFormat = new DecimalFormat("###");
        return super.displayInfo() + " and idNv = " + idNv + " and salary = " + decimalFormat.format(salary);
    }

    public static void main(String[] args) {
        Employee employee = new Employee(18, "HOA", "NV01", 100000);
        String display = employee.displayInfo();
        System.out.println(display);
    }
}
